package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import project.mbti.report.entity.ReportType;

@ApiModel(description = "신고 요청 데이터")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportAddDto {

    @ApiModelProperty(value = "댓글 ID", example = "1", required = true)
    @NotNull(message = "댓글 ID는 필수입니다.")
    private Long commentId;

    @ApiModelProperty(value = "신고 유형", required = true)
    @NotNull(message = "신고 유형을 선택해주세요.")
    private ReportType type;

    @ApiModelProperty(value = "신고 이유", example = "너무 심한 욕설이에요!")
    @Length(min = 1, max = 500, message = "신고 내용은 1자 이상, 500자 이하로 입력해주세요.")
    @NotBlank(message = "신고 사유를 작성해주세요.")
    private String description;

}
