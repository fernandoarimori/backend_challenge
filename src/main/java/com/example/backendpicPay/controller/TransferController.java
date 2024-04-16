package com.example.backendpicPay.controller;

import com.example.backendpicPay.model.dto.TransferDTO;
import com.example.backendpicPay.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity postTransfer(@RequestBody TransferDTO dto, UriComponentsBuilder uriComponentsBuilder){
        return transferService.postTransfer(dto,uriComponentsBuilder);
    }
}
