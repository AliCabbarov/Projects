package exception;

import enums.ExceptionsEnums;

import java.time.LocalDateTime;

public class InvalidOptionException extends RuntimeException{
    private String message;
    private LocalDateTime localDateTime;
    public InvalidOptionException(ExceptionsEnums exceptions) {
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
