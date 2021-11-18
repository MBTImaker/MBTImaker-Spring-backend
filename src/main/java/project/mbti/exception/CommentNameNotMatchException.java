package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class CommentNameNotMatchException extends BusinessException {
    public CommentNameNotMatchException() {
        super(ErrorCode.COMMENT_NAME_NOT_MATCH);
    }
}
