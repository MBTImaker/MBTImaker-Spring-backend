package project.mbti.exception;

import project.mbti.response.error.ErrorCode;
import project.mbti.response.error.ErrorResponse;

import java.util.List;

public class CommentWriterNameLengthException extends BusinessException {
    public CommentWriterNameLengthException(List<ErrorResponse.FieldError> errors) {
        super(ErrorCode.INVALID_INPUT_VALUE, errors);
    }
}
