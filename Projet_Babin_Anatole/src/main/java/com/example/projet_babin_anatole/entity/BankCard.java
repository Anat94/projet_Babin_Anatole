package com.example.projet_babin_anatole.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BankCard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCarte;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

}

