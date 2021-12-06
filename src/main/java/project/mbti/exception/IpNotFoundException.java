package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class IpNotFoundException extends BusinessException {
    public IpNotFoundException() {
        super(ErrorCode.IP_NOT_FOUND);
    }
}
