package com.insoft.price_calculation.exception;

import com.insoft.price_calculation.model.dto.AppErrorMessage;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var br = e.getBindingResult();
        var errorMessage = br.getFieldErrors().stream()
                .map(ef -> ef.getField() + " " + ef.getDefaultMessage())
                .collect(Collectors.joining("; "));
        log.error("Bad request: " + errorMessage, e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppErrorMessage(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }

}
