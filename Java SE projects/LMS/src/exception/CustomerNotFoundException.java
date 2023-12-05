package exception;

import enums.ExceptionCustomer;

import java.time.LocalDateTime;

public class CustomerNotFoundException extends RuntimeException {
    private String message;
    private LocalDateTime exceptionTime;

    public CustomerNotFoundException(ExceptionCustomer exception) {
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
