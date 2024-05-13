package com.ngprogramming.RestAPIExample.exceptions;

import com.ngprogramming.RestAPIExample.controller.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
            ex.getFieldErrors().stream().forEach(error -> errorMap.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap) ;
    }


    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<Object> dataNotFound(DataNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()) ;
    }

}
