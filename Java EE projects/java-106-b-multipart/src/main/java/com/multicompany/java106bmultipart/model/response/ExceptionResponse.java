package com.multicompany.java106bmultipart.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Builder
public class ExceptionResponse {
    private final String message;
    private final int httpStatus;
    private final LocalDateTime localDateTime;
}
