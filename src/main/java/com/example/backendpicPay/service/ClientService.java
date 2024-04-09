package com.example.backendpicPay.service;

import com.example.backendpicPay.model.PicClient;
import com.example.backendpicPay.model.dto.PostPicClientDTO;
import com.example.backendpicPay.model.dto.ResponseUserDTO;
import com.example.backendpicPay.model.repository.PicClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ClientService {
    @Autowired
    private PicClientRepository clientRepository;

    public ResponseEntity postUser(PostPicClientDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        PicClient newPost = new PicClient(dto);
        var uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(newPost.getId()).toUri();
        clientRepository.save(newPost);
        return ResponseEntity.created(uri).body(new ResponseUserDTO(newPost));
    }
}
