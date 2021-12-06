package project.mbti.report;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.mbti.report.dto.ReportDto;
import project.mbti.report.entity.Report;
import project.mbti.report.entity.ReportState;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("select new project.mbti.report.dto." +
            "ReportDto(r.id, r.subject, r.description, r.reason, r.state, r.comment.id, r.comment.content, r.comment.state, r.ip) " +
            "from Report r " +
            "join r.comment c " +
            "where r.state = :state")
    Page<ReportDto> findReportDtoPage(Pageable pageable, @Param("state") ReportState state);

    @Modifying(clearAutomatically = true)
    @Query("update Report r set r.state = 'CANCELED', r.reason = :reason where r.comment.id = :commentId and r.state = 'REPORTED'")
    void bulkUpdateReportStateByCommentId(@Param("commentId") Long commentId, @Param("reason") String reason);

    Optional<Report> findByIpAndCommentId(String ip, Long commentId);
}
