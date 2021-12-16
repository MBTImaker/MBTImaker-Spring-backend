package project.mbti.report.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.mbti.comment.entity.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "reports")
@EntityListeners(AuditingEntityListener.class)
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Enumerated(value = STRING)
    private ReportSubject subject;

    @Lob
    private String description;

    @Lob
    private String reason;

    @Enumerated(value = STRING)
    private ReportState state;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    private String ip;

    @Builder
    public Report(Comment comment, ReportSubject subject, String description, String ip) {
        this.comment = comment;
        this.subject = subject;
        this.description = description;
        this.state = ReportState.REPORTED;
        this.reason = "";
        this.ip = ip;
    }

    public void process(ReportState state, String reason) {
        this.state = state;
        this.reason = reason + " - " + LocalDateTime.now();
    }
}
