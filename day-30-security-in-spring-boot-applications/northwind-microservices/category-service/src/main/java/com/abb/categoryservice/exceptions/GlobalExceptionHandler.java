package com.abb.categoryservice.exceptions;

import com.abb.categoryservice.model.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorData> handleResourceNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<>(new ErrorData(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
