package com.example.backendpicPay.service;

import com.example.backendpicPay.exception.UnableToNotify;
import com.example.backendpicPay.model.TransferNotify;
import com.example.backendpicPay.model.dto.NotifyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotifyService {
    private Logger LOGGER = LoggerFactory.getLogger(NotifyService.class);
    public RestClient client;

    public NotifyService(RestClient.Builder client) {
        this.client = client
                .baseUrl("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
                .build();
    }

    @KafkaListener(topics = "topic-notify", groupId = "picpay")
    public void sendNotify(TransferNotify transferNotify) {
        LOGGER.info("Start notify "+ transferNotify);
        var response = client.get().retrieve().toEntity(NotifyDTO.class);
        if (response.getStatusCode().isError() || !response.getBody().message()) {
            throw new UnableToNotify("Could not notify");
        }
        LOGGER.info("End notify", response.getBody().message());
    }
}
