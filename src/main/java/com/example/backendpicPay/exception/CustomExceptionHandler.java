package com.example.backendpicPay.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = UnableToNotify.class)
    public ResponseEntity<Object> customResponse(UnableToNotify e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = NotStoreException.class)
    public ResponseEntity<Object> customResponse(NotStoreException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = NotAuthorizeException.class)
    public ResponseEntity<Object> customResponse(NotAuthorizeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = NotEnoughMoneyException.class)
    public ResponseEntity<Object> customResponse(NotEnoughMoneyException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
