package com.example.SMS.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class StudentsExceptions extends Throwable {

    @ExceptionHandler(value = {SMSExceptions.class})
    public ResponseEntity<Object> handleException(SMSExceptions e){
       ErrorMessage message = new ErrorMessage(
               e.toString(),
               HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}
