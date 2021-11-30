package project.mbti.report;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.comment.CommentRepository;
import project.mbti.exception.AlreadyDeletedCommentException;
import project.mbti.comment.entity.Comment;
import project.mbti.exception.*;
import project.mbti.report.dto.*;
import project.mbti.report.entity.Report;
import project.mbti.report.entity.ReportState;
import project.mbti.report.entity.ReportSubject;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static project.mbti.comment.entity.CommentState.*;
import static project.mbti.report.entity.ReportState.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public ReportSlackDto create(ReportWriteDto dto) {
        if (dto.getSubject().equals(ReportSubject.NOT_FOUND))
            throw new InvalidReportSubjectException();

        final Comment comment = commentRepository.findById(dto.getCommentId()).orElseThrow(CommentNotFoundException::new);

        Report report = Report.builder()
                .comment(comment)
                .subject(dto.getSubject())
                .description(dto.getDescription())
                .build();

        reportRepository.save(report);

        return ReportSlackDto.builder()
                .reportId(report.getId())
                .subject(dto.getSubject())
                .description(dto.getDescription())
                .commentId(comment.getId())
                .commentContent(comment.getContent())
                .build();
    }

    public Page<ReportDto> getReportPage(int page, int size, ReportState state) {
        page = (page == 0 ? 0 : page - 1);
        Direction direction = state.equals(REPORTED) ? ASC : DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "id"));
        return reportRepository.findReportDtoPage(pageable, state);
    }

    // TODO: 신고 처리할 때, 사유도 적는 걸로? -> 혹시나 필요할 때, 확인 용도
    @Transactional
    public ReportDto process(ReportProcessDto dto) {
        final Report report = reportRepository.findById(dto.getReportId()).orElseThrow(ReportNotFoundException::new);

        if (report.getState().equals(COMPLETED))
            throw new AlreadyCompletedReportException();
        if (dto.getState().equals(REPORTED) || dto.getState().equals(NOT_FOUND))
            throw new InvalidReportStateException();
        if (report.getComment().getState().equals(DELETED))
            throw new AlreadyDeletedCommentException();

        report.updateState(dto.getState());
        if (dto.getState().equals(COMPLETED)) {
            report.getComment().updateState(DELETED);
            reportRepository.bulkUpdateReportStateByCommentId(report.getComment().getId());
        }

        return ReportDto.builder()
                .reportId(report.getId())
                .subject(report.getSubject())
                .description(report.getDescription())
                .reportState(report.getState())
                .commentId(report.getComment().getId())
                .commentContent(report.getComment().getContent())
                .commentState(report.getComment().getState())
                .build();
    }
}
