package project.mbti.report.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.mbti.report.entity.ReportSubject;

@Getter
@Builder
@AllArgsConstructor
public class ReportSlackDto {

    private Long reportId;
    private ReportSubject subject;
    private String description;
    private Long commentId;
    private String commentContent;
}
