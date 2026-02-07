package com.example.aparna.SpringBootWeb.advices;

import com.example.aparna.SpringBootWeb.excceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;


import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){
        APIError apiError = APIError.builder().
                status(HttpStatus.NOT_FOUND).
                message(exception.getMessage()).
                build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<?>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        StringBuilder errorMessage = new StringBuilder();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errorMessage.append(error.getField())
                                .append(": ")
                                .append(error.getDefaultMessage())
                                .append("; ")
                );

        APIError apiError = APIError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(errorMessage.toString())
                .build();

        return buildErrorResponseEntity(apiError);
    }


    private ResponseEntity<APIResponse<?>> buildErrorResponseEntity(APIError apiError) {
        return new ResponseEntity<>(new APIResponse<>(apiError), apiError.getStatus());
    }
}
