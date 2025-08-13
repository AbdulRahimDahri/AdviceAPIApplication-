package com.descenedigital.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        return ResponseEntity.status(500).body("Internal error: " + ex.getMessage());
    }

}
