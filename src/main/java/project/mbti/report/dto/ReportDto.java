package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@ApiModel(description = "신고 응답 데이터")
@Data
@Builder
@AllArgsConstructor
public class ReportDto {

    @ApiModelProperty(value = "신고 ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "해당되는 댓글 FK", example = "1")
    private Long commentId;

    @ApiModelProperty(value = "신고 상태", example = "REPORTED")
    private String state;

    @ApiModelProperty(value = "신고 유형", example = "ABUSE")
    private String type;

    @ApiModelProperty(value = "신고 구체적인 이유", example = "정말 욕설이 심하네요!")
    private String description;

    @ApiModelProperty(value = "신고 날짜", example = "2021-11-08 10:23:31")
    private LocalDateTime createdDate;

}