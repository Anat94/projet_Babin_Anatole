package com.example.projet_babin_anatole.controller;

import com.example.projet_babin_anatole.entity.Client;
import com.example.projet_babin_anatole.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Gestion des Clients", description = "Endpoints pour la gestion des clients")
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Créer un client", description = "Endpoint pour ajouter un client.")
    @ApiResponse(responseCode = "200", description = "Client créé avec succès")
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @Operation(summary = "Lister tous les clients", description = "Retourne la liste des clients.")
    @ApiResponse(responseCode = "200", description = "Retourne les clients")
    @GetMapping
    public List<Client> listAllClients() {
        return clientService.listAllClients();
    }

    @Operation(summary = "Recuperer un client", description = "Retourne un client en fonctionn de son id.")
    @ApiResponse(responseCode = "200", description = "Retourne le client")
    @GetMapping("/{id}")
    public Optional<Client> listClientById(@PathVariable Long id) {
        return clientService.listClientById(id);
    }

    @Operation(summary = "Modifie un client", description = "Modifie un client en fonctionn de son id.")
    @ApiResponse(responseCode = "200", description = "Modifie le client")
    @PutMapping("/{id}")
    public Client modifyClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.modifyClient(id, client);
    }

    @Operation(summary = "Supprime un client", description = "Supprime un client en fonctionn de son id.")
    @ApiResponse(responseCode = "200", description = "Supprime le client")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @Operation(summary = "Affecte un advisor", description = "Affecter un client en fonction de son id a un advisor en fonctiond e son id")
    @ApiResponse(responseCode = "200", description = "Affecte un client")
    @PutMapping("/{clientId}/affect/{advisorId}")
    public Client affecterConseiller(@PathVariable Long clientId, @PathVariable Long advisorId) {
        return clientService.affectClientToAdvisor(clientId, advisorId);
    }
}