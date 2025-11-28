package com.example.projet_babin_anatole.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Advisor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @ManyToOne
    @JsonIgnore
    private Agency agency;

    @OneToMany(mappedBy = "advisor")
    @JsonIgnore
    private List<Client> clients;

    private Double tauxInteretDefaut;
}