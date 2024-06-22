package com.insoft.price_calculation.exception;

import com.insoft.price_calculation.model.dto.AppErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppErrorMessage> handleAllException(Exception e) {
        log.error("Bad request: " + e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

}
