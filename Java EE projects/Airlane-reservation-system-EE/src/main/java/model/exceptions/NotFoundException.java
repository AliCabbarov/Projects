package model.exceptions;

import model.enums.ExceptionEnums;

public class NotFoundException extends RuntimeException {
    private final String message;
    public NotFoundException(ExceptionEnums e,String val,long id){
        super(String.format(e.getMessage(),val,id));
        message = e.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
