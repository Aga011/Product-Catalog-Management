package com.Aga.Agali.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String,String>>handleBadRequest(BadRequestException ex){
        Map<String,String>error=new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>handleVAlidException(MethodArgumentNotValidException ex){
        Map<String,String>error=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err->{
            error.put(err.getField(),err.getDefaultMessage());
        });
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String,String>>conflictException(ConflictException ex){
        Map<String,String>error=new HashMap<>();
        error.put("error", ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>>notFoundException(ResourceNotFoundException ex){
        Map<String,String>error=new HashMap<>();
        error.put("error",ex.getMessage());
        return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>>internationalException(Exception ex){
        Map<String,String>error=new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
