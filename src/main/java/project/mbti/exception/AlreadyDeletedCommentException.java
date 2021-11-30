package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class AlreadyDeletedCommentException extends BusinessException {

    public AlreadyDeletedCommentException() {
        super(ErrorCode.ALREADY_DELETED_COMMENT);
    }
}
