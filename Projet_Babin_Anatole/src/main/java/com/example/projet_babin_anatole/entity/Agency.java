package com.example.projet_babin_anatole.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Agency {

    @Id
    @Column(length = 5)
    private String identification;

    private LocalDate dateCreation;

    @OneToOne(cascade = CascadeType.ALL)
    private Boss boss;

    @OneToMany(mappedBy = "agency")
    private List<Advisor> conseillers;

    public Agency() {
        this.dateCreation = LocalDate.now();
    }
}