package com.example.SMS.Exceptions;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private final String message;
    private final HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorMessage(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}