package com.example.backendpicPay.model;

import com.example.backendpicPay.model.dto.TransferDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class TransferNotify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    @NotNull
    private BigDecimal value;
    @NotNull
    private String from;
    @NotNull
    private String to;
    @CreatedDate
    private LocalDateTime created;
    private Boolean isAllowed;

    public TransferNotify(Boolean isAllowed) {
        this.isAllowed = false;
    }

    public void setAllowed(Boolean allowed) {
        isAllowed = allowed;
    }

    public TransferNotify(TransferDTO dto) {
        this.value = dto.value();
        this.from = dto.from();
        this.to = dto.to();
    }
}


