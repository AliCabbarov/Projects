package enums;

import java.time.LocalDateTime;

public enum Exception {
    BOOK_NOT_FOUND_EXCEPTION("Book not found", LocalDateTime.now()),
    INVALI_OPTION_EXCEPTION("Invalid option", LocalDateTime.now()),
    BOOK_STOCK_NOT_FOUND_EXCEPTION("Book Stock Not Found", LocalDateTime.now()),
    BOOK_BASE_NOT_FOUND_EXCEPTION("Book base Not Found ", LocalDateTime.now()),
    WRONG_FORMAT_EXCEPTION("Wrong format ",LocalDateTime.now()),
    WRONG_STORAGE_STATUS_EXCEPTION("Wrong storage status ",LocalDateTime.now()),
    WRONG_NAME_EXCEPTION("Wrong name", LocalDateTime.now());
        private String message;
    private LocalDateTime exceptionTime;

    Exception(String message, LocalDateTime exceptionTime) {
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
