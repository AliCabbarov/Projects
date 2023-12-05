package com.library.libmanagesys.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private String message;
    private int code;
    private LocalDateTime exceptionTime;
}
