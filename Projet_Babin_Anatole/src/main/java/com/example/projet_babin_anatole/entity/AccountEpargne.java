package com.example.projet_babin_anatole.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EPARGNE")
public class AccountEpargne extends Account {

    private Double remunerationRate;

    public AccountEpargne() {
        super();
        this.remunerationRate = 0.03;
    }

    public Double getRemunerationRate() { return remunerationRate; }
    public void setRemunerationRate(Double remunerationRate) { this.remunerationRate = remunerationRate; }
}