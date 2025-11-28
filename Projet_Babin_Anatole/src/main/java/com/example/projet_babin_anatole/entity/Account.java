package com.example.projet_babin_anatole.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte")
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private Double pay;
    private LocalDate openDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    public Account() {
        this.openDate = LocalDate.now();
    }

    // --- GETTERS & SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public Double getPay() { return pay; }
    public void setPay(Double pay) { this.pay = pay; }

    public LocalDate getOpenDate() { return openDate; }
    public void setOpenDate(LocalDate openDate) { this.openDate = openDate; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}