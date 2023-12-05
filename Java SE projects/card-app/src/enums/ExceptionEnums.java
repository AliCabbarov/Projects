package enums;

import java.time.LocalDateTime;

public enum ExceptionEnums {
    NOT_FOUND_EXCEPTION("not found", LocalDateTime.now()),
    LOW_BALANCE_EXCEPTION("Low balance",LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option",LocalDateTime.now()),
    WRONG_CARD_NUMBER_EXCEPTION("Wrong card Number",LocalDateTime.now()),
    OPERATION_NOT_FOUND_EXCEPTION("operation not found",LocalDateTime.now()),
    SAME_CARD_EXCEPTION("Same card",LocalDateTime.now());
    private String message;
    private LocalDateTime exceptionTime;

    ExceptionEnums(String message, LocalDateTime exceptionTime) {
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
