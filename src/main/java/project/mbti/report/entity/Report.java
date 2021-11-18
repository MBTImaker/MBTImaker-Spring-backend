package project.mbti.report.entity;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.mbti.comment.entity.Comment;
import project.mbti.report.dto.ReportDto;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "REPORT")
@EntityListeners(AuditingEntityListener.class)
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    @JsonIgnore
    private Comment comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type")
    private ReportType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_state")
    private ReportState state;

    private String description;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Builder
    public Report(Optional<Comment> comment, ReportType type, String description){
        this.comment = (comment.isEmpty() ? this.getComment() : comment.get());
        this.state = ReportState.REPORTED;
        this.type = type;
        this.description = description;
    }

    public ReportDto create(){
        return ReportDto.builder()
            .id(getId())
            .commentId(getComment().getId())
            .description(getDescription())
            .type(getType().toString())
            .state(getState().toString())
            .build();
    }

    public void update(ReportState state){
        this.state = state;
    }
}
