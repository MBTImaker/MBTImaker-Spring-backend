package project.mbti.exception;

import project.mbti.response.error.ErrorCode;
import project.mbti.response.error.ErrorResponse;

import java.util.List;

public class ReportDescriptionLengthException extends BusinessException {
    public ReportDescriptionLengthException(List<ErrorResponse.FieldError> errors) {
        super(ErrorCode.INVALID_INPUT_VALUE, errors);
    }
}
