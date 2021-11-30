package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class AlreadyCompletedReportException extends BusinessException {

    public AlreadyCompletedReportException() {
        super(ErrorCode.ALREADY_COMPLETED_REPORT);
    }
}
