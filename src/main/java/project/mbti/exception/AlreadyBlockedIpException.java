package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class AlreadyBlockedIpException extends BusinessException {

    public AlreadyBlockedIpException() {
        super(ErrorCode.ALREADY_BLOCKED_IP);
    }
}
