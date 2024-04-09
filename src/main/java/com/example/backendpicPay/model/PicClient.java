package com.example.backendpicPay.model;

import com.example.backendpicPay.model.dto.PostPicClientDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "tb_client")
@Entity(name = "Client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class PicClient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String register;
    @NotNull
    @Column(unique = true)
    @Email
    private String email;
    @NotNull
    private String password;
    @Positive
    private BigDecimal wallet;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PicClinentType type;

    public PicClient(PostPicClientDTO dto) {
        this.name = dto.name();
        this.register = dto.register();
        this.email = dto.email();
        this.password = dto.password();
        this.wallet = dto.wallet();}

    public void pays(BigDecimal value) {
        this.wallet.subtract(value);
    }

    public void recieve(BigDecimal value) {
        this.wallet.add(value);
    }
}
