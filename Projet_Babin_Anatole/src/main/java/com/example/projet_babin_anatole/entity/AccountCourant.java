package com.example.projet_babin_anatole.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class AccountCourant extends Account {

    private Double overdraft;

    public AccountCourant() {
        super();
        this.overdraft = 1000.0;
    }

    public Double getOverdraft() { return overdraft; }
    public void setOverdraft(Double overdraft) { this.overdraft = overdraft; }
}