package project.mbti.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@ApiModel(description = "테스트 코드 요청 데이터 모델")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestCodeDto {

    @ApiModelProperty(name = "testCode", value = "테스트 코드", example = "010-110-111-000", required = true)
    @Pattern(regexp = "^([01]{3}-[01]{3}-[01]{3}-[01]{3})$", message = "테스트 코드 형식이 잘못되었습니다.")
    private String testCode;
}
