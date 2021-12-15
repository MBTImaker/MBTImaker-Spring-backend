package project.mbti.comment.dto;

import com.vdurmont.emoji.EmojiParser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.mbti.exception.CommentWriterNameLengthException;
import project.mbti.response.error.ErrorResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static lombok.AccessLevel.PROTECTED;

@ApiModel(description = "댓글 삭제 요청 데이터 모델")
@Data
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CommentDeleteDto {

    @ApiModelProperty(value = "댓글 PK", example = "1")
    @NotNull(message = "댓글 PK는 필수입니다.")
    private Long id;

    @ApiModelProperty(value = "작성자 이름", example = "만두", required = true)
    private String name;

    @ApiModelProperty(value = "작성자 비밀번호", example = "1234", required = true)
    @Pattern(regexp = "^[0-9]{4,20}$", message = "작성자 비밀번호는 4자 이상 20자 이하 숫자만 입력해주세요.")
    private String password;

    public void removeAllEmojisAndValidateLengthOfName() {
        this.name = EmojiParser.removeAllEmojis(getName()).trim().replaceAll("\\s+", " ");
        if (this.name.isBlank())
            throw new CommentWriterNameLengthException(ErrorResponse.FieldError.of("name", getName(), "작성자 이름을 입력해주세요."));
        if (this.name.length() < 2 || this.name.length() > 10)
            throw new CommentWriterNameLengthException(ErrorResponse.FieldError.of("name", getName(), "작성자 이름은 2자 이상, 10자 이하로 입력해주세요."));
    }
}
