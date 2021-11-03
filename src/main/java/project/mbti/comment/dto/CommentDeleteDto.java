package project.mbti.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

import static lombok.AccessLevel.PROTECTED;

@ApiModel(description = "댓글 삭제 요청 데이터 모델")
@Data
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CommentDeleteDto {

    @ApiModelProperty(value = "댓글 PK", example = "1")
    @NotBlank(message = "댓글 PK는 필수입니다.")
    private Long id;

    @ApiModelProperty(value = "작성자 이름", example = "만두", required = true)
    @Length(min = 2, max = 10, message = "작성자 이름은 2자 이상, 10자 이하로 입력해주세요.")
    @NotBlank(message = "작성자 이름을 입력해주세요.")
    private String name;

    @ApiModelProperty(value = "작성자 비밀번호", example = "1234", required = true)
    @Length(min = 4, max = 20, message = "작성자 비밀번호는 4자 이상, 20자 이하로 입력해주세요.")
    @NotBlank(message = "작성자 비밀번호을 입력해주세요.")
    private String password;
}
