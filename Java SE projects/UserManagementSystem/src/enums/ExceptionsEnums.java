package enums;

import java.time.LocalDateTime;

public enum ExceptionsEnums {
    WRONG_FORMAT("wrong format", LocalDateTime.now()),
    USER_NOT_FOUND_EXCEPTION("user not found", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("invalid option" , LocalDateTime.now());
    private String message;
    private LocalDateTime localDateTime;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    ExceptionsEnums(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime =localDateTime;

    }

    public String getMessage() {
        return message;
    }
}
