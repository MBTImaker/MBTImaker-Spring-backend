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
import project.mbti.comment.dto.*;
import project.mbti.response.result.ResultCode;
import project.mbti.response.result.ResultResponse;
import project.mbti.comment.entity.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import static project.mbti.response.result.ResultCode.*;

@Api(tags = "댓글 API")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "댓글 작성")
    @PostMapping("/comment")
    public ResponseEntity<ResultResponse> write(@Validated @RequestBody CommentWriteDto dto, HttpServletRequest request) {
        final String clientIp = request.getHeader("X-Forwarded-For");
        final CommentWriteResultType result = commentService.create(dto.getMbti(), dto.getName(), dto.getPassword(), dto.getContent(), 0L, clientIp);
        final CommentWriteResponseDto commentWriteResponseDto = new CommentWriteResponseDto(result, clientIp);
        final ResultCode resultCode = result.equals(CommentWriteResultType.SUCCESS) ? WRITE_COMMENT_SUCCESS : WRITE_COMMENT_FAILURE;

        return ResponseEntity.ok()
                .body(ResultResponse.of(resultCode, commentWriteResponseDto));
    }

    @ApiOperation(value = "대댓글 작성")
    @PostMapping("/reply")
    public ResponseEntity<ResultResponse> reply(@Validated @RequestBody ReplyWriteDto dto, HttpServletRequest request) {
        final String clientIp = request.getHeader("X-Forwarded-For");
        final CommentWriteResultType result = commentService.create(dto.getMbti(), dto.getName(), dto.getPassword(), dto.getContent(), dto.getParentId(), clientIp);
        final CommentWriteResponseDto commentWriteResponseDto = new CommentWriteResponseDto(result, clientIp);
        final ResultCode resultCode = result.equals(CommentWriteResultType.SUCCESS) ? WRITE_COMMENT_SUCCESS : WRITE_COMMENT_FAILURE;

        return ResponseEntity.ok()
                .body(ResultResponse.of(resultCode, commentWriteResponseDto));
    }

    @ApiOperation(value = "댓글 삭제")
    @PatchMapping("/comment")
    public ResponseEntity<ResultResponse> delete(@Validated @RequestBody CommentDeleteDto dto) {
        final Comment comment = commentService.delete(dto.getId(), dto.getName(), dto.getPassword());
        final CommentDto commentDto = comment.convert();

        return ResponseEntity.ok()
                .body(ResultResponse.of(DELETE_COMMENT_SUCCESS, commentDto));
    }

    @ApiOperation(value = "댓글 페이징 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지", example = "1", required = true),
            @ApiImplicitParam(name = "size", value = "댓글 개수", example = "5", required = true)
    })
    @GetMapping("/comment")
    public ResponseEntity<ResultResponse> commentList(
            @Validated @NotNull(message = "페이지를 입력해주세요.") @RequestParam int page,
            @Validated @NotNull(message = "댓글 개수를 입력해주세요.") @RequestParam int size) {
        final Page<CommentDto> commentPage = commentService.getCommentPage(page, size);

        return ResponseEntity.ok()
                .body(ResultResponse.of(FIND_COMMENT_PAGE_SUCCESS, commentPage));
    }

    @ApiOperation(value = "대댓글 페이징 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지", example = "1", required = true),
            @ApiImplicitParam(name = "size", value = "대댓글 개수", example = "5", required = true),
            @ApiImplicitParam(name = "parentId", value = "부모 댓글 PK", example = "1", required = true)
    })
    @GetMapping("/reply")
    public ResponseEntity<ResultResponse> replyList(
            @Validated @NotNull(message = "부모 댓글 PK는 필수입니다.") @RequestParam Long parentId,
            @Validated @NotNull(message = "페이지를 입력해주세요.") @RequestParam int page,
            @Validated @NotNull(message = "대댓글 개수를 입력해주세요.") @RequestParam int size) {
        final Page<ReplytDto> replyPage = commentService.getReplyPage(parentId, page, size);

        return ResponseEntity.ok()
                .body(ResultResponse.of(FIND_REPLY_PAGE_SUCCESS, replyPage));
    }
}
