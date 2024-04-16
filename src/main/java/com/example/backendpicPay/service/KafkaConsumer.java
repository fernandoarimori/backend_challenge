package com.example.backendpicPay.service;

import com.example.backendpicPay.model.TransferNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    private NotifyService notifyService;

    public void notifyKafka(TransferNotify transferNotify) {
        notifyService.sendNotify(transferNotify);
    }
}
