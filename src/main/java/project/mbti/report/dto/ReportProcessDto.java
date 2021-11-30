package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import project.mbti.report.entity.ReportState;

import javax.validation.constraints.NotNull;

@ApiModel(description = "신고 처리 데이터 모델")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportProcessDto {

    @ApiModelProperty(value = "신고 PK", example = "1", required = true)
    @NotNull(message = "신고 PK는 필수입니다.")
    private Long reportId;

    @ApiModelProperty(value = "신고 상태", example = "COMPLETED", required = true, notes = "COMPLETED 혹은 CANCELED만 입력해주세요. ")
    @NotNull(message = "처리하려는 신고 상태는 필수입니다.")
    private ReportState state;
}
