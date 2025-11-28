package com.example.projet_babin_anatole.service;
import com.example.projet_babin_anatole.entity.Client;
import com.example.projet_babin_anatole.entity.Advisor;
import com.example.projet_babin_anatole.repository.ClientRepository;
import com.example.projet_babin_anatole.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdvisorRepository advisorRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> listAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> listClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client modifyClient(Long id, Client clientModifie) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setNom(clientModifie.getNom());
                    client.setPrenom(clientModifie.getPrenom());
                    client.setAdresse(clientModifie.getAdresse());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new RuntimeException("Client non trouvé !"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client affectClientToAdvisor(Long clientId, Long advisorId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        Advisor advisor = advisorRepository.findById(advisorId)
                .orElseThrow(() -> new RuntimeException("Advisor introuvable"));

        if (advisor.getClients() != null && advisor.getClients().size() >= 10) {
            throw new RuntimeException("ERREUR : Ce advisor a déjà 10 clients !");
        }

        client.setConseiller(advisor);

        return clientRepository.save(client);
    }
}