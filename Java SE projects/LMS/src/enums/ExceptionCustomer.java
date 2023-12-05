package enums;

import java.time.LocalDateTime;

public enum ExceptionCustomer {
    CUSTOMER_NOT_FOUND_EXCEPTION("costumer not found",LocalDateTime.now());



    private String message;
    private LocalDateTime exceptionTime;

    ExceptionCustomer(String message, LocalDateTime exceptionTime) {
        this.message = message;
        this.exceptionTime = exceptionTime;
    }
    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
