package com.example.backendpicPay.model.dto;

import com.example.backendpicPay.model.TransferNotify;

import java.math.BigDecimal;

public record TransferDTO(
        BigDecimal value,
        String buyClient,
        String sellStore
) {
    public TransferDTO(TransferNotify postedTransfer) {
        this(postedTransfer.getValue(), postedTransfer.getBuyClient(), postedTransfer.getSellStore());
    }
}
