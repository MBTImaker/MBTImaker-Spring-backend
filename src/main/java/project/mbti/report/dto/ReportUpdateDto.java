package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

import lombok.*;
import project.mbti.report.entity.ReportState;

@ApiModel(description = "신고 상태 수정 데이터")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportUpdateDto {

    @ApiModelProperty(value = "신고 ID", example = "1", required = true)
    @NotNull(message = "신고 ID는 필수입니다.")
    private Long id;

    @ApiModelProperty(value = "", example = "COMPLETED", required = true)
    @NotNull(message = "상태 값은 필수입니다.")
    private ReportState state;

}
