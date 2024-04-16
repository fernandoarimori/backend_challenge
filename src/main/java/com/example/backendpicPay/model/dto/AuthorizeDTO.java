package com.example.backendpicPay.model.dto;

public record AuthorizeDTO(
        String message
) {
    public Boolean isAllowed(){
        return message.equals("Autorizado");
    }
}
