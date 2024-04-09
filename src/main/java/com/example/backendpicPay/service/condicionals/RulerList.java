package com.example.backendpicPay.service.condicionals;

import com.example.backendpicPay.model.PicClient;
import com.example.backendpicPay.model.TransferNotify;

public interface RulerList {
    void budinessRule(PicClient store, PicClient client, TransferNotify transferNotify);
}
