package com.example.backendpicPay.service;

import com.example.backendpicPay.model.TransferNotify;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private KafkaTemplate<String, TransferNotify> kafkaTemplate;

    public void sendKafka(TransferNotify notify){
        kafkaTemplate.send("topic-notify", notify);
    }
}
