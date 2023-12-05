package exception;

import enums.ExceptionsEnums;

import java.time.LocalDateTime;

public class WrongFormatException extends RuntimeException{
    private String message;
    private LocalDateTime localDateTime;
    public WrongFormatException(ExceptionsEnums exceptions) {
        super(exceptions.getMessage());
        this.message = exceptions.getMessage();
        this.localDateTime = exceptions .getLocalDateTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
