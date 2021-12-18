package project.mbti.comment.dto;

import com.vdurmont.emoji.EmojiParser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import project.mbti.MBTI;
import project.mbti.exception.CommentWriterNameLengthException;
import project.mbti.response.error.ErrorResponse;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@ApiModel(description = "댓글 작성 요청 데이터 모델")
@Data
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CommentWriteDto {

    @ApiModelProperty(value = "MBTI 유형", example = "ISTJ", required = true)
    @NotNull(message = "MBTI 유형은 필수입니다.")
    @Enumerated(value = STRING)
    private MBTI mbti;

    @ApiModelProperty(value = "작성자 이름", example = "만두", required = true)
    @Length(min = 2, max = 10, message = "작성자 이름은 2자 이상, 10자 이하로 입력해주세요.")
    @NotBlank(message = "작성자 이릉믈 입력해주세요.")
    private String name;

    @ApiModelProperty(value = "작성자 비밀번호", example = "1234", required = true)
    @Pattern(regexp = "^[0-9]{4,20}$", message = "작성자 비밀번호는 4자 이상 20자 이하 숫자만 입력해주세요.")
    private String password;

    @ApiModelProperty(value = "댓글 내용", example = "우와 신기해요!", required = true)
    @Length(min = 1, max = 500, message = "댓글 내용은 1자 이상, 500자 이하로 입력해주세요.")
    @NotBlank(message = "댓글 내용을 입력해주세요.")
    private String content;

    public void removeAllEmojisAndValidateLengthOfName() {
        this.name = EmojiParser.removeAllEmojis(getName()).trim().replaceAll("\\s+", " ");
        if (this.name.isBlank())
            throw new CommentWriterNameLengthException(ErrorResponse.FieldError.of("name", getName(), "작성자 이름을 입력해주세요."));
        if (this.name.length() < 2 || this.name.length() > 10)
            throw new CommentWriterNameLengthException(ErrorResponse.FieldError.of("name", getName(), "작성자 이름은 2자 이상, 10자 이하로 입력해주세요."));
    }

    public void applyLineBreaksAndRemoveContinuousLineBreaksOfContent() {
        this.content = getContent().trim().replaceAll("(\r?\n)", "<br>").replaceAll("(<br>){2,}", "<br>").replaceAll("\\s+", " ");
    }
}
