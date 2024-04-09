package com.example.backendpicPay.service.condicionals;

import com.example.backendpicPay.exception.NotStoreException;
import com.example.backendpicPay.model.PicClient;
import com.example.backendpicPay.model.PicClinentType;
import com.example.backendpicPay.model.TransferNotify;
import org.springframework.stereotype.Component;

@Component
public class IsStore implements RulerList{
    @Override
    public void budinessRule(PicClient store, PicClient client, TransferNotify transferNotify) {
        if (store.getType()== PicClinentType.STORE){
            transferNotify.setAllowed(true);
        }
        throw new NotStoreException("Is not a Store account");
    }
}
