package com.example.projet_babin_anatole.service;

import com.example.projet_babin_anatole.entity.*;
import com.example.projet_babin_anatole.repository.ClientRepository;
import com.example.projet_babin_anatole.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;


    public AccountCourant createCourantAccount(Long clientId, Double payInitial) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        AccountCourant compte = new AccountCourant();
        compte.setClient(client);
        compte.setPay(payInitial);
        compte.setAccountNumber("C-" + System.currentTimeMillis());

        return accountRepository.save(compte);
    }

    public AccountEpargne createEpargneAccount(Long clientId, Double payInitial) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        AccountEpargne compte = new AccountEpargne();
        compte.setClient(client);
        compte.setPay(payInitial);
        compte.setAccountNumber("E-" + System.currentTimeMillis());

        return accountRepository.save(compte);
    }


    @Transactional
    public void payment(Long idCompteSource, Long idCompteDest, Double montant) {
        if (montant <= 0) throw new RuntimeException("Le montant doit être positif");

        Account source = accountRepository.findById(idCompteSource)
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));

        Account dest = accountRepository.findById(idCompteDest)
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));

        if (source.getPay() < montant) {
            throw new RuntimeException("Pay insuffisant pour le payment");
        }

        source.setPay(source.getPay() - montant);
        dest.setPay(dest.getPay() + montant);

        accountRepository.save(source);
        accountRepository.save(dest);
    }

    public List<Account> lireTousLesComptes() {
        return accountRepository.findAll();
    }

    public List<Account> auditComptesDangereux() {
        List<Account> tousLesAccounts = accountRepository.findAll();

        return tousLesAccounts.stream()
                .filter(compte -> compte.getPay() < -5000)
                .toList();
    }
}