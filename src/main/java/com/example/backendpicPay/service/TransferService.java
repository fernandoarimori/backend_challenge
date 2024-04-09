package com.example.backendpicPay.service;

import com.example.backendpicPay.model.dto.TransferDTO;
import com.example.backendpicPay.model.TransferNotify;
import com.example.backendpicPay.model.repository.PicClientRepository;
import com.example.backendpicPay.model.repository.TransferRepository;
import com.example.backendpicPay.service.condicionals.RulerList;
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

    public ResponseEntity postTransfer(TransferDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var store = picClientRepository.getReferenceById(dto.from());
        var client = picClientRepository.getReferenceById(dto.to());
        var value = dto.value();
        TransferNotify newTransfer = new TransferNotify(dto);
        rulerLists.forEach(
                rulerList -> rulerList.budinessRule(store, client, newTransfer)
        );
        if (newTransfer.getIsAllowed()){
            var postedTransfer = transferRepository.save(newTransfer);
            client.pays(value);
            store.recieve(value);
            picClientRepository.save(client);
            picClientRepository.save(store);
            var uri = uriComponentsBuilder.path("/transfer/{id}").buildAndExpand(postedTransfer).toUri()
            return ResponseEntity.created(uri).body(new TransferDTO(postedTransfer));
        }
        return ResponseEntity.badRequest().build();
    }
}
