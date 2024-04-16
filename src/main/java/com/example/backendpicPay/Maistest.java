package com.example.backendpicPay;

import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Maistest {
    public static void main(String[] args) {
        BigDecimal value = new BigDecimal(200.00);
        BigDecimal wallet = new BigDecimal(1000.10);
        System.out.println(wallet.add(value).setScale(2,RoundingMode.HALF_EVEN));
    }
}
