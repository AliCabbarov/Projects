package com.multicompany.java106bmultipart.model.handler;

import com.multicompany.java106bmultipart.model.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handler(Exception e) {
        log.error("exception -> {}",e.getMessage());
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handler(AccessDeniedException e) {
        log.error("exception -> {}",e.getLocalizedMessage());
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponse> handler(NullPointerException  e) {
        log.error("exception -> {}",e.getMessage());
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }


}
