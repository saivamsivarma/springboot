package com.example.SMS.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class SMSExceptions extends RuntimeException{
    public SMSExceptions(String message) {
        super(message);
    }

    public SMSExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}