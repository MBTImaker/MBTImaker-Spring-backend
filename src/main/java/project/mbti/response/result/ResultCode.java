package project.mbti.response.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Comment
    WRITE_SUCCESS(200,"C100", "댓글 작성 성공"),
    DELETE_SUCCESS(200,"C101", "댓글 삭제 성공"),
    FIND_COMMENT_PAGE_SUCCESS(200,"C102", "댓글 페이징 조회 성공"),

    ;

    private int status;
    private final String code;
    private final String message;
}