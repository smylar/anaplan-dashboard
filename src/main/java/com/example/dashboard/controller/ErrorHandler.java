package com.example.dashboard.controller;

import com.example.dashboard.domain.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static com.example.dashboard.domain.Error.GENERAL;

@Slf4j
@ControllerAdvice
public class ErrorHandler  {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleGeneralError(final Exception ex, final WebRequest request) {
        log.warn("Unexpected error", ex);
        return ResponseEntity.status(GENERAL.getHttpStatus().value())
                .body(GENERAL);
    }
}
