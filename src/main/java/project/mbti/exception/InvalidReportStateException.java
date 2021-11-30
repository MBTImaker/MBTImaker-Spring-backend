package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class InvalidReportStateException extends BusinessException {

    public InvalidReportStateException() {
        super(ErrorCode.INVALID_REPORT_STATE);
    }
}
