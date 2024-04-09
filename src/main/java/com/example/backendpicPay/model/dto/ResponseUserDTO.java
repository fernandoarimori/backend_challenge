package com.example.backendpicPay.model.dto;

import com.example.backendpicPay.model.PicClient;
import com.example.backendpicPay.model.PicClinentType;

import java.math.BigDecimal;

public record ResponseUserDTO(
        String name,
        String register,
        String email,
        String password,
        BigDecimal wallet,
        PicClinentType type
) {

    public ResponseUserDTO(PicClient newPost) {
        this(
                newPost.getName(),
                newPost.getRegister(),
                newPost.getEmail(),
                newPost.getPassword(),
                newPost.getWallet(),
                newPost.getType()
        );
    }
}
