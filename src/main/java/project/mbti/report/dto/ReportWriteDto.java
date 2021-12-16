package project.mbti.report.dto;

import com.vdurmont.emoji.EmojiParser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import project.mbti.exception.CommentWriterNameLengthException;
import project.mbti.exception.ReportDescriptionLengthException;
import project.mbti.report.entity.ReportSubject;
import project.mbti.response.error.ErrorResponse;

import javax.validation.constraints.NotNull;

@ApiModel(description = "신고 요청 데이터 모델")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportWriteDto {

    @ApiModelProperty(value = "댓글 PK", example = "1", required = true)
    @NotNull(message = "댓글 PK는 필수입니다.")
    private Long commentId;

    @ApiModelProperty(value = "신고 유형", example = "ABUSE", required = true)
    @NotNull(message = "신고 유형은 필수입니다.")
    private ReportSubject subject;

    @ApiModelProperty(value = "신고 사유", example = "너무 심한 욕설이에요!")
    private String description;

    public void removeAllEmojisAndApplyLineBreaksAndRemoveContinuousLineBreakAndValidateLengthOfDescription() {
        this.description = EmojiParser.removeAllEmojis(getDescription()).trim().replaceAll("(\r?\n){2,}", "<br>").replaceAll("\\s+", " ");
        if (this.description.isBlank())
            throw new ReportDescriptionLengthException(ErrorResponse.FieldError.of("description", getDescription(), "신고 사유를 입력해주세요."));
        if (this.description.length() > 500)
            throw new ReportDescriptionLengthException(ErrorResponse.FieldError.of("description", getDescription(), "신고 사유는 500자 이하로 입력해주세요."));
    }
}
