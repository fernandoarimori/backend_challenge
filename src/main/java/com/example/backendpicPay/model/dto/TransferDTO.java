package com.example.backendpicPay.model.dto;

import com.example.backendpicPay.model.TransferNotify;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferDTO(
        BigDecimal value,
        String from,
        String to,
        LocalDateTime created
) {
    public TransferDTO(TransferNotify postedTransfer) {
        this(postedTransfer.getValue(), postedTransfer.getFrom(), postedTransfer.getTo(), postedTransfer.getCreated());
    }
}
