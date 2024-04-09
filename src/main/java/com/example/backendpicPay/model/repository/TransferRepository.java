package com.example.backendpicPay.model.repository;

import com.example.backendpicPay.model.TransferNotify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferNotify, Long> {
}
