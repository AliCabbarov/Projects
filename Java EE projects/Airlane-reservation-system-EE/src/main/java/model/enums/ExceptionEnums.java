package model.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {
    NULL_OBJECT_EXCEPTION("object value is null!"),
    QUERY_BUILDER_IS_NOT_VALID("Query is not valid!"), UPDATE_FAILED("update failed"), NOT_FOUND("not found %s: %d");
    private final String message;
    ExceptionEnums(String message) {
        this.message = message;
    }

}
