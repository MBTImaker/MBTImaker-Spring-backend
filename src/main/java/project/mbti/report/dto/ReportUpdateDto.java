package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import project.mbti.report.entity.ReportState;

@ApiModel(description = "신고 상태 수정 데이터")
@Data
@Builder
@AllArgsConstructor
public class ReportUpdateDto {

    @ApiModelProperty(value = "신고 ID", example = "1", required = true)
    @NotBlank(message = "신고 ID는 필수입니다.")
    private Long id;

    @ApiModelProperty(value = "", example = "COMPLETED", required = true)
    @NotBlank(message = "상태 값은 필수입니다.")
    private ReportState state;

}
