package com.example.SMS.Exceptions;


public class SMSExceptions extends RuntimeException{
    public SMSExceptions(String message) {
        super(message);
    }

    public SMSExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}