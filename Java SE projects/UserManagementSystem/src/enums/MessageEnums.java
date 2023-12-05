package enums;

import java.time.LocalDateTime;

public enum MessageEnums {
    REGISTER_SUCCESSFULLY("register successfully!!", LocalDateTime.now()),
    DELETE_SUCCESSFULLY("delete successfully", LocalDateTime.now()),
    UPDATE_SUCCESSFULLY("update successfully",LocalDateTime.now());
    String message;
    LocalDateTime localDateTime;

    MessageEnums(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
