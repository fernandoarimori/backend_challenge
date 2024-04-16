package com.example.backendpicPay.service.condicionals;

import com.example.backendpicPay.exception.NotEnoughMoneyException;
import com.example.backendpicPay.model.PicClient;
import com.example.backendpicPay.model.TransferNotify;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.BitSet;

@Component
public class NotEnoughMoney implements RulerList{
    @Override
    public void budinessRule(PicClient store, PicClient client, TransferNotify transferNotify) {
        if (client.getWallet().compareTo(transferNotify.getValue())==-1){
            throw new NotEnoughMoneyException("Not enough money");
        }
        transferNotify.setAllowed(true);
    }
}
