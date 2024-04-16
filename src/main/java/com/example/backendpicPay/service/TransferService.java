package com.example.backendpicPay.service;

import com.example.backendpicPay.model.TransferNotify;
import com.example.backendpicPay.model.dto.TransferDTO;
import com.example.backendpicPay.model.repository.PicClientRepository;
import com.example.backendpicPay.model.repository.TransferRepository;
import com.example.backendpicPay.service.condicionals.RulerList;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private PicClientRepository picClientRepository;
    @Autowired
    private List<RulerList> rulerLists = new ArrayList<>();
    @Autowired
    private ServiceAuth serviceAuth;

    @Autowired
    private KafkaConsumer kafkaConsumer;
    @Autowired
    private NotifyService notifyService;

    @Transactional
    public ResponseEntity postTransfer(TransferDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var store = picClientRepository.getReferenceById(dto.sellStore());
        var client = picClientRepository.getReferenceById(dto.buyClient());
        var value = dto.value();
        System.out.println(value);
        TransferNotify newTransfer = new TransferNotify(dto);
        System.out.println(newTransfer.getBuyClient() + " " + newTransfer.getSellStore());
        serviceAuth.authorize();
        rulerLists.forEach(
                rulerList -> rulerList.budinessRule(store, client, newTransfer)
        );
        if (newTransfer.getIsAllowed()) {
            client.pays(value);
            store.recieve(value);
            System.out.println(store.getWallet());
            picClientRepository.save(client);
            picClientRepository.save(store);
            kafkaConsumer.notifyKafka(newTransfer);
            var postedTransfer = transferRepository.save(newTransfer);
            var uri = uriComponentsBuilder.path("/transfer/{id}").buildAndExpand(postedTransfer).toUri();
            return ResponseEntity.created(uri).body(new TransferDTO(postedTransfer));
        }
        return ResponseEntity.badRequest().build();
    }
}
