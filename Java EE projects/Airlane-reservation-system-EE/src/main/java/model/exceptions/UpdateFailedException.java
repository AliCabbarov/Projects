package model.exceptions;

import model.enums.ExceptionEnums;

public class UpdateFailedException extends RuntimeException {
    private final String message;

    public UpdateFailedException(ExceptionEnums enums) {
        super(enums.getMessage());
        message = enums.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
