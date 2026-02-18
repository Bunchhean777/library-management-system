package com.testing.library.common.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.testing.library.common.record.ApiError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobleException extends RuntimeException{
        
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        ApiError body = new ApiError(
            Instant.now(),
            404,
            "NOT_FOUND",
            ex.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusiness(BusinessException ex, HttpServletRequest request) {
        ApiError body = new ApiError(
            Instant.now(),
            400,
            "BUSINESS_ERROR",
            ex.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(body);
    }    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        
        String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + " : " + e.getDefaultMessage())
            .findFirst()
            .orElse("Valdation error");

        ApiError body = new ApiError(
            Instant.now(),
            400,
            "VALIDATION_ERROR",
            message,
            request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex, HttpServletRequest request) {        
        
        ApiError body = new ApiError(
            Instant.now(),
            505,
            "INTERNAL_SERVER_ERROR",
            ex.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(body);
    }

}