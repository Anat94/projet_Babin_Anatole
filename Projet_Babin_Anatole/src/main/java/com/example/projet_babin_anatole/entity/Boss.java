package com.example.projet_babin_anatole.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Boss {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToOne(mappedBy = "boss")
    private Agency agency;
}