package com.techavidus.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomException {
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<?> exceptionHandle(NullPointerException ne) {
        System.out.println("exception occurs " + ne.getMessage());
        return new ResponseEntity<>(ne.getMessage(), HttpStatus.GATEWAY_TIMEOUT);

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = BusinessException.class)
    public Map<String, String> reacordNotFound(BusinessException be) {

        Map<String, String> map = new HashMap<>();
        map.put("errorMsg", be.getMessage());
        map.put("errorCode", String.valueOf(HttpStatus.NOT_FOUND.value()));
        return map;

    }
}
