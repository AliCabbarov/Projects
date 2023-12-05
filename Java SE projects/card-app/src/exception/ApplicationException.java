package exception;

import enums.ExceptionEnums;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{
    private String message;
    private LocalDateTime exceptionTime;

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }

    public ApplicationException(ExceptionEnums exception) {
        super(exception.getMessage());
        this.message = exception.getMessage();
        this.exceptionTime = exception.getExceptionTime();
    }
}
