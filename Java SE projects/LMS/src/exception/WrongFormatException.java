package exception;

import enums.Exception;

import java.time.LocalDateTime;

public class WrongFormatException extends RuntimeException {
    private String message;
    private LocalDateTime exceptionTime;

    public WrongFormatException(Exception exception) {
        super(exception.getMessage());
        this.message = exception.getMessage();
        this.exceptionTime = exception.getExceptionTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
