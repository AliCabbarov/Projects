package com.library.libmanagesys.model.enums;

import lombok.Getter;

@Getter
public enum Exceptions {
    NOT_FOUND(404,"not found!");
    private String message;
    private int code;

    Exceptions(int code,String message) {
        this.message = message;
        this.code = code;
    }
}
