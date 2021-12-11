package project.mbti.block.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "IP 차단 요청 데이터 모델")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlockIpDto {

    @ApiModelProperty(value = "차단할 IP", example = "111.111.111.111,11.111.11.111", required = true)
    @NotBlank(message = "차단할 IP는 필수입니다.")
    private String ip;
}
