package com.example.backendpicPay.service;

import com.example.backendpicPay.exception.NotAuthorizeException;
import com.example.backendpicPay.model.dto.AuthorizeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ServiceAuth {
    private Logger LOGGER = LoggerFactory.getLogger(ServiceAuth.class);
    private RestClient client;

    public ServiceAuth(RestClient.Builder clientBuilder) {
        this.client =
                clientBuilder
                        .baseUrl("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
                        .build();

    }

    public void authorize (){
        LOGGER.info("authorize start");
        var response = client.get().retrieve().toEntity(AuthorizeDTO.class);
        if(response.getStatusCode().isError() || !response.getBody().isAllowed()){
            throw new NotAuthorizeException("Not authorize!");
        }
        System.out.println("autorize");
        LOGGER.info("Log: end autho", response.getBody());
    }
}
