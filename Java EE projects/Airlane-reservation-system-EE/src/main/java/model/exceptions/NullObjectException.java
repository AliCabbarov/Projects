package model.exceptions;

import model.enums.ExceptionEnums;

public class NullObjectException extends RuntimeException {
    private final String message;
    public NullObjectException(ExceptionEnums e){
        super(e.getMessage());
        message = e.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
