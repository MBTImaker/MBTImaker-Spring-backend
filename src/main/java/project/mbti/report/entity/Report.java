package project.mbti.report.entity;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import project.mbti.comment.entity.Comment;
import project.mbti.report.dto.ReportDto;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "REPORT")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Enumerated(EnumType.STRING)
    private ReportType type;

    @Enumerated(EnumType.STRING)
    private ReportState state;

    private String description;

    private Integer count;

    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public Report(Long id, Comment comment, ReportType type, String description){
        this.comment = comment;
        this.type = type;
        this.description = description;
    }

    public ReportDto toEntity(){
        return ReportDto.builder()
            .id(getId())
            .commentId(getComment().getId())
            .description(getDescription())
            .type(getType().toString())
            .state(getState().toString())
            .count(getCount())
            .build();
    }
}
