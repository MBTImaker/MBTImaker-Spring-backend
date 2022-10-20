package project.mbti.report;

import static org.springframework.data.domain.Sort.Direction.*;
import static project.mbti.comment.entity.CommentState.*;
import static project.mbti.report.dto.ReportWriteResultType.*;
import static project.mbti.report.entity.ReportState.*;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import project.mbti.async.SlackWebhookService;
import project.mbti.block.BlockRepository;
import project.mbti.block.entity.Block;
import project.mbti.comment.CommentRepository;
import project.mbti.comment.entity.Comment;
import project.mbti.exception.AlreadyCompletedReportException;
import project.mbti.exception.AlreadyDeletedCommentException;
import project.mbti.exception.CommentNotFoundException;
import project.mbti.exception.InvalidReportStateException;
import project.mbti.exception.InvalidReportSubjectException;
import project.mbti.exception.ReportNotFoundException;
import project.mbti.report.dto.ReportDto;
import project.mbti.report.dto.ReportProcessDto;
import project.mbti.report.dto.ReportWriteResultType;
import project.mbti.report.entity.Report;
import project.mbti.report.entity.ReportState;
import project.mbti.report.entity.ReportSubject;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReportService {

	private final ReportRepository reportRepository;
	private final CommentRepository commentRepository;
	private final BlockRepository blockRepository;
	private final EntityManager em;
	private final SlackWebhookService slackWebhookService;

	@Transactional
	public ReportWriteResultType create(ReportSubject subject, String description, Long commentId, String ip) {
		if (subject.equals(ReportSubject.NOT_FOUND))
			throw new InvalidReportSubjectException();

		final Comment comment = commentRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
		if (comment.getState().equals(DELETED))
			throw new AlreadyDeletedCommentException();

		ReportWriteResultType result;
		if (blockRepository.findByIp(ip).isPresent())
			result = BLOCKED_IP;
		else if (reportRepository.findByIpAndCommentId(ip, commentId).isPresent())
			result = ALREADY_EXIST;
		else {
			final Report report = Report.builder()
				.comment(comment)
				.subject(subject)
				.description(description)
				.ip(ip)
				.build();
			slackWebhookService.sendReport(subject, description, commentId, comment, report);
			result = SUCCESS;
			reportRepository.save(report);
		}

		return result;
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
			reportRepository.bulkUpdateReportStateByCommentId(report.getComment().getId(),
				"이미 처리된 신고(id:" + dto.getReportId() + ") - " + LocalDateTime.now());
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
