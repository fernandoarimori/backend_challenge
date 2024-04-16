package com.example.backendpicPay.exception;

public class UnableToNotify extends RuntimeException {
    public UnableToNotify(String couldNotNotify) {
        super(couldNotNotify);
    }
}
