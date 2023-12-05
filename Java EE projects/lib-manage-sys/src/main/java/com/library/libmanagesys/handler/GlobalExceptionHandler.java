package com.library.libmanagesys.handler;

import com.library.libmanagesys.model.dto.response.ExceptionResponse;
import com.library.libmanagesys.model.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handler(ApplicationException e) {
        ExceptionResponse build = ExceptionResponse.builder()
                .message(e.getExceptions().getMessage())
                .code(e.getExceptions().getCode())
                .exceptionTime(LocalDateTime.now()).build();

        log.error(e.getMessage());

        return new ResponseEntity<>(build, HttpStatus.valueOf(build.getCode()));


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handler(Exception e) {
        ExceptionResponse build = ExceptionResponse.builder()
                .message(e.getMessage())
                .code(500)
                .exceptionTime(LocalDateTime.now()).build();

        log.error(e.getMessage());

        return new ResponseEntity<>(build, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
