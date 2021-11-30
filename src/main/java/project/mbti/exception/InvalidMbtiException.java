package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class InvalidMbtiException extends BusinessException {
    public InvalidMbtiException() {
        super(ErrorCode.INVALID_MBTI);
    }
}
