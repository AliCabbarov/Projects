package model.exceptions;

import model.enums.ExceptionEnums;

public class QueryBuilderIsNotValidException extends RuntimeException {

    private final String message;

    public QueryBuilderIsNotValidException(ExceptionEnums enums) {
        super(enums.getMessage());
        message = enums.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
