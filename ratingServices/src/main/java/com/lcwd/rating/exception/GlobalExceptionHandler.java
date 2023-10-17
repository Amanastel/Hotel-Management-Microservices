package com.lcwd.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException me, WebRequest req){
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> customerExceptionHandler(NotFoundException ce, WebRequest req){


        ErrorDetails err= new ErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(ce.getMessage());
        err.setUri(req.getDescription(false));

        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }
    
    




}










