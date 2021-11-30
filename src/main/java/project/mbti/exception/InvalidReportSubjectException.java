package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class InvalidReportSubjectException extends BusinessException {

    public InvalidReportSubjectException() {
        super(ErrorCode.INVALID_REPORT_SUBJECT);
    }
}
