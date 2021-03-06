package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.mbti.comment.entity.CommentState;
import project.mbti.report.entity.ReportState;
import project.mbti.report.entity.ReportSubject;

import static lombok.AccessLevel.PROTECTED;

@ApiModel(description = "신고 응답 데이터 모델")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class ReportDto {

    @ApiModelProperty(value = "신고 PK", example = "2")
    private Long reportId;

    @ApiModelProperty(value = "신고 유형", example = "욕설/비하")
    private ReportSubject subject;

    @ApiModelProperty(value = "신고 접수 사유", example = "너무 심한 욕설이에요!")
    private String description;

    @ApiModelProperty(value = "신고 처리 사유", example = "'sh1t'은 'shit' 비속어에 해당.")
    private String reason;

    @ApiModelProperty(value = "신고 상태", example = "REPORTED")
    private ReportState reportState;

    @ApiModelProperty(value = "댓글 PK", example = "1")
    private Long commentId;

    @ApiModelProperty(value = "댓글 내용", example = "sh1t")
    private String commentContent;

    @ApiModelProperty(value = "댓글 상태", example = "DELETED")
    private CommentState commentState;

    @ApiModelProperty(value = "댓글 작성자 IP", example = "0:0:0:0:0:0:0:1")
    private String writerIp;
}
