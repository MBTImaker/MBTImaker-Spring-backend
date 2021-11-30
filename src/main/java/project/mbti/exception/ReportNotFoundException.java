package project.mbti.exception;

import project.mbti.response.error.ErrorCode;

public class ReportNotFoundException extends BusinessException{

    public ReportNotFoundException() {
        super(ErrorCode.REPORT_NOT_FOUND);
    }
}
