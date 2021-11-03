package project.mbti.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Common
    INTERNAL_SERVER_ERROR(500, "U001", "내부 서버 오류입니다."),
    INVALID_INPUT_VALUE(400, "U002", "유효하지 않은 입력입니다."),
    METHOD_NOT_ALLOWED(405, "U003", "허용되지 않은 HTTP method입니다."),
    INVALID_TYPE_VALUE(400, "U004", "입력 타입이 유효하지 않습니다."),

    // Comment
    COMMENT_NOT_FOUND(400, "C001", "존재하지 않는 댓글입니다."),
    COMMENT_NAME_NOT_MATCH(400, "C002", "댓글 작성자 이름이 일치하지 않습니다."),
    COMMENT_PASSWORD_NOT_MATCH(400, "C003", "댓글 비밀번호가 일치하지 않습니다."),
    ;

    private int status;
    private final String code;
    private final String message;
}
