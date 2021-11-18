package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class MbtiNotFoundException extends BusinessException {
    public MbtiNotFoundException() {
        super(ErrorCode.MBTI_NOT_FOUND);
    }
}
