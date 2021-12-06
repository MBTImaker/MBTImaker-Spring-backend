package project.mbti.report.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(description = "댓글 신고 결과 응답 데이터 모델")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportWriteResponseDto {

    @ApiModelProperty(value = "댓글 신고 결과", example = "SUCCESS")
    private ReportWriteResultType result;

    @ApiModelProperty(value = "댓글 신고자 IP", example = "111.111.111.111,11.111.11.111")
    private String clientIp;
}
