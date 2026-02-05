package com.example.aparna.SpringBootWeb.advices;

import com.example.aparna.SpringBootWeb.excceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handleResourceNotFound(ResourceNotFoundException exception){
        APIError apiError = APIError.builder().
                status(HttpStatus.NOT_FOUND).
                message(exception.getMessage()).
                build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
