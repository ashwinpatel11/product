package com.example.assigmment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ApiResponse> handleResource(ProductException ex) {
        ApiResponse response = new ApiResponse();
        response.setMsg(ex.getMessage());
        response.setSuccess(true);
        response.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
