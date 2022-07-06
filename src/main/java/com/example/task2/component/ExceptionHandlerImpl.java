package com.example.task2.component;

import com.example.task2.exception.NotFoundException;
import com.example.task2.exception.PSQLException;
import com.example.task2.payload.ApiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerImpl{

    @ExceptionHandler({NotFoundException.class})
    public HttpEntity<?> handle(NotFoundException e){
        return ResponseEntity.status(400).body(new ApiResponse("Error element not found",false));
    }

    @ExceptionHandler({PSQLException.class})
    public HttpEntity<?> handle(PSQLException e){
        return ResponseEntity.status(400).body(new ApiResponse("Name is already registered", false));
    }
}
