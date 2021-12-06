package project.mbti.report;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import project.mbti.block.BlockRepository;
import project.mbti.block.entity.Block;
import project.mbti.comment.CommentRepository;
import project.mbti.exception.AlreadyDeletedCommentException;
import project.mbti.comment.entity.Comment;
import project.mbti.exception.*;
import project.mbti.report.dto.*;
import project.mbti.report.entity.Report;
import project.mbti.report.entity.ReportState;
import project.mbti.report.entity.ReportSubject;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.HttpMethod.POST;
import static project.mbti.comment.entity.CommentState.*;
import static project.mbti.report.dto.ReportWriteResultType.*;
import static project.mbti.report.entity.ReportState.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;
    private final BlockRepository blockRepository;
    private final EntityManager em;

    @Value("${webhook.slack.url}")
    private String url;

    @Transactional
    public ReportWriteResultType create(ReportSubject subject, String description, Long commentId, String ip) {
        if (subject.equals(ReportSubject.NOT_FOUND))
            throw new InvalidReportSubjectException();

        ReportWriteResultType result;
        if (blockRepository.findByIp(ip).isPresent())
            result = BLOCKED_IP;
        else if (reportRepository.findByIpAndCommentId(ip, commentId).isPresent())
            result = ALREADY_EXIST;
        else {
            final Comment comment = commentRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);

            final Report report = Report.builder()
                    .comment(comment)
                    .subject(subject)
                    .description(description)
                    .ip(ip)
                    .build();

            result = SUCCESS;
            reportRepository.save(report);
            postToSlack(subject, description, commentId, comment, report);
        }

        return result;
    }

    private void postToSlack(ReportSubject subject, String description, Long commentId, Comment comment, Report report) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> slackRequest = new HashMap<>();
        slackRequest.put("text",
                "🔥🔥 새로운 신고가 접수되었어요! 🔥🔥\n\n" +
                        "#️⃣ 신고 id: " + report.getId() + "\n" +
                        "✅ 신고 유형: " + subject.getName() + "\n" +
                        "😫 신고 사유: " + description + "\n\n" +
                        "#️⃣ 댓글 id: " + commentId + "\n" +
                        "🤬 댓글 내용: " + comment.getContent());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(slackRequest);
        restTemplate.exchange(url, POST, entity, String.class);
    }

    public Page<ReportDto> getReportPage(int page, int size, ReportState state) {
        page = (page == 0 ? 0 : page - 1);

        final Direction direction = state.equals(REPORTED) ? ASC : DESC;
        final Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "id"));

        return reportRepository.findReportDtoPage(pageable, state);
    }

    @Transactional
    public ReportDto process(ReportProcessDto dto) {
        if (dto.getState().equals(REPORTED) || dto.getState().equals(NOT_FOUND))
            throw new InvalidReportStateException();

        final Report report = validateReport(dto);
        report.process(dto.getState(), dto.getReason());

        if (dto.getState().equals(COMPLETED)) {
            report.getComment().updateState(DELETED);
            blockRepository.save(new Block(report.getComment().getIp()));
            em.flush();
            reportRepository.bulkUpdateReportStateByCommentId(report.getComment().getId(), "이미 처리된 신고(id:" + dto.getReportId() + ") - " + LocalDateTime.now());
        }

        return ReportDto.builder()
                .reportId(report.getId())
                .subject(report.getSubject())
                .description(report.getDescription())
                .reason(report.getReason())
                .reportState(report.getState())
                .commentId(report.getComment().getId())
                .commentContent(report.getComment().getContent())
                .commentState(report.getComment().getState())
                .build();
    }

    private Report validateReport(ReportProcessDto dto) {
        final Report report = reportRepository.findById(dto.getReportId()).orElseThrow(ReportNotFoundException::new);

        if (report.getState().equals(COMPLETED))
            throw new AlreadyCompletedReportException();
        if (report.getComment().getState().equals(DELETED))
            throw new AlreadyDeletedCommentException();

        return report;
    }
}
