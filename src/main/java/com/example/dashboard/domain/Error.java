package com.example.dashboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Error {
    GENERAL(HttpStatus.INTERNAL_SERVER_ERROR, "Something terrible has happened");

    private final HttpStatus httpStatus;
    private final String message;

    Error(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getName() {
        return this.name();
    }
}
