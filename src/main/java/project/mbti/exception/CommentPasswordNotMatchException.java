package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class CommentPasswordNotMatchException extends BusinessException {
    public CommentPasswordNotMatchException() {
        super(ErrorCode.COMMENT_PASSWORD_NOT_MATCH);
    }
}
