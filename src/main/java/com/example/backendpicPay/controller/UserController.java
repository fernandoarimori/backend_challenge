package com.example.backendpicPay.controller;

import com.example.backendpicPay.model.dto.PostPicClientDTO;
import com.example.backendpicPay.model.repository.PicClientRepository;
import com.example.backendpicPay.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PicClientRepository repository;


    @PostMapping
    public ResponseEntity postUser(@RequestBody PostPicClientDTO dto, UriComponentsBuilder uriComponentsBuilder){
        return clientService.postUser(dto, uriComponentsBuilder);
    }

    @DeleteMapping
    private ResponseEntity expodeDb(){
        repository.deleteAll();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("BOM");
    }
}
