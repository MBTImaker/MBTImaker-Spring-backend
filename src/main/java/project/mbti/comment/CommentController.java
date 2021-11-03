package project.mbti.comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.mbti.comment.dto.CommentDeleteDto;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.dto.CommentWriteDto;
import project.mbti.comment.entity.MBTI;
import project.mbti.response.result.ResultResponse;
import project.mbti.comment.entity.Comment;

import javax.validation.constraints.NotNull;

import static project.mbti.response.result.ResultCode.*;

@Api(tags = "댓글 API")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "댓글 작성")
    @PostMapping("/comment")
    public ResponseEntity<ResultResponse> write(@Validated @RequestBody CommentWriteDto dto) {
        final Comment comment = commentService.create(dto.getMbti(), dto.getName(), dto.getPassword(), dto.getContent(), null);
        final CommentDto commentDto = comment.convert();

        return ResponseEntity.ok()
                .body(ResultResponse.of(WRITE_SUCCESS, commentDto));
    }

    @ApiOperation(value = "댓글 삭제")
    @DeleteMapping("/comment")
    public ResponseEntity<ResultResponse> delete(@Validated @RequestBody CommentDeleteDto dto) {
        commentService.delete(dto.getId(), dto.getName(), dto.getPassword());

        return ResponseEntity.ok()
                .body(ResultResponse.of(DELETE_SUCCESS, null));
    }

    @ApiOperation(value = "댓글 페이징 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지", example = "1", required = true),
            @ApiImplicitParam(name = "mbti", value = "MBTI", example = "ISTJ", required = true)
    })
    @GetMapping("/comment")
    public ResponseEntity<ResultResponse> commentList(@Validated @NotNull(message = "페이지를 입력해주세요.") @RequestParam int page,
                                                      @Validated @NotNull(message = "MBTI 유형은 필수입니다.") @RequestParam MBTI mbti) {
        final Page<CommentDto> commentPage = commentService.getCommentPage(page, mbti);

        return ResponseEntity.ok()
                .body(ResultResponse.of(FIND_COMMENT_PAGE_SUCCESS, commentPage));
    }
}
