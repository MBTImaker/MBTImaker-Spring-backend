package project.mbti.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.mbti.MBTI;
import project.mbti.comment.entity.CommentState;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@ApiModel(description = "댓글 응답 데이터 모델")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CommentDto {

    @ApiModelProperty(value = "댓글 PK", example = "1")
    private Long id;

    @ApiModelProperty(value = "댓글 생성 일자", example = "2021-10-30 08:31:01")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "MBTI", example = "ISTJ")
    private MBTI mbti;

    @ApiModelProperty(value = "댓글 작성자 이름", example = "만두")
    private String name;

    @ApiModelProperty(value = "댓글 작성자 비밀번호", example = "1234")
    private String password;

    @ApiModelProperty(value = "댓글 내용", example = "우와 신기해요!")
    private String content;

    @ApiModelProperty(value = "대댓글 개수", example = "5")
    private int childSize;

    @ApiModelProperty(value = "댓글 상태", example = "WRITTEN")
    private CommentState state;
}
