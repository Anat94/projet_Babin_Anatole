package com.example.projet_babin_anatole.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String address;

    private String codePostal;
    private String ville;
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "conseiller_id")
    private Advisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<BankCard> cartesBancaires;

    public Client() {
    }

    // --- GETTERS & SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return name; }
    public void setNom(String name) { this.name = name; }

    public String getPrenom() { return surname; }
    public void setPrenom(String surname) { this.surname = surname; }

    public String getAdresse() { return address; }
    public void setAdresse(String address) { this.address = address; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public List<Account> getComptes() { return accounts; }
    public void setComptes(List<Account> accounts) { this.accounts = accounts; }

    public void setConseiller(Advisor advisor) {this.advisor = advisor;}
    public Advisor getConseiller() { return advisor; }

    public List<BankCard> getCartesBancaires() { return cartesBancaires; }

    public void setCartesBancaires(List<BankCard> cartesBancaires) { this.cartesBancaires = cartesBancaires;}
}