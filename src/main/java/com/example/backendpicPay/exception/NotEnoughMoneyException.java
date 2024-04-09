package com.example.backendpicPay.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message){
        super(message);
    }
}
