package project.mbti.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.mbti.comment.entity.MBTI;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@ApiModel(description = "대댓글 응답 데이터 모델")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class ReplytDto {

    @ApiModelProperty(value = "대댓글 PK", example = "2")
    private Long id;

    @ApiModelProperty(value = "부모 댓글 FK", example = "1",  notes = "댓글인 경우, PK와 동일")
    private Long parentId;

    @ApiModelProperty(value = "대댓글 생성 일자", example = "2021-10-30 08:31:01")
    private LocalDateTime createdDate;

    @ApiModelProperty(value = "MBTI", example = "ISTJ")
    private MBTI mbti;

    @ApiModelProperty(value = "대댓글 작성자 이름", example = "만두")
    private String name;

    @ApiModelProperty(value = "대댓글 작성자 비밀번호", example = "1234")
    private String password;

    @ApiModelProperty(value = "대댓글 내용", example = "우와 신기해요!")
    private String content;
}
