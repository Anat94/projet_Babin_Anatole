package com.example.projet_babin_anatole.service;

import com.example.projet_babin_anatole.entity.BankCard;
import com.example.projet_babin_anatole.entity.Client;
import com.example.projet_babin_anatole.entity.CardType;
import com.example.projet_babin_anatole.repository.BankCardRepository;
import com.example.projet_babin_anatole.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BankCardService {

    @Autowired
    private BankCardRepository cardRepository;

    @Autowired
    private ClientRepository clientRepository;

    public BankCard setCard(Long clientId, CardType type) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        BankCard card = new BankCard();
        card.setClient(client);
        card.setCardType(type);

        card.setNumeroCarte(UUID.randomUUID().toString().substring(0, 16));

        return cardRepository.save(card);
    }

    public List<BankCard> getAllCards() {
        return cardRepository.findAll();
    }
}