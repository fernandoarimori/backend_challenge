package com.example.backendpicPay.model.dto;

import com.example.backendpicPay.model.PicClinentType;

import java.math.BigDecimal;

public record PostPicClientDTO(
        String name,
        String register,
        String email,
        String password,
        BigDecimal wallet,
        PicClinentType type
) {
}
