package com.example.projet_babin_anatole.controller;

import com.example.projet_babin_anatole.entity.Account;
import com.example.projet_babin_anatole.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "Gestion des comptes", description = "Endpoints pour la gestion des comptes")
@RequestMapping("/accounts")
public class CompteController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Créer un compte courant", description = "Endpoint pour ajouter un compte courant.")
    @ApiResponse(responseCode = "200", description = "Compte courant créé avec succès")
    @PostMapping("/courant")
    public Account createCourantAccount(@RequestParam Long clientId, @RequestParam Double pay) {
        return accountService.createCourantAccount(clientId, pay);
    }

    @Operation(summary = "Créer un compte epargne", description = "Endpoint pour ajouter un compte epargne.")
    @ApiResponse(responseCode = "200", description = "Compte epargne créé avec succès")
    @PostMapping("/epargne")
    public Account createEpargneAccount(@RequestParam Long clientId, @RequestParam Double pay) {
        return accountService.createEpargneAccount(clientId, pay);
    }

    @Operation(summary = "Liste tous les comptes", description = "Endpoint pour lister les comptes.")
    @ApiResponse(responseCode = "200", description = "Liste des comptes créé")
    @GetMapping
    public List<Account> lireTousLesComptes() {
        return accountService.lireTousLesComptes();
    }

    @Operation(summary = "Liste tous les comptes", description = "Endpoint pour lister les comptes.")
    @ApiResponse(responseCode = "200", description = "Liste des comptes créé")
    @PostMapping("/payment")
    public String faireVirement(@RequestBody VirementRequest request) {
        accountService.payment(request.getSourceId(), request.getDestId(), request.getMontant());
        return "Virement effectué avec succès !";
    }

    @Operation(summary = "Realiser un audit", description = "Endpoint pour faire un audt")
    @ApiResponse(responseCode = "200", description = "Audit effectue")
    @GetMapping("/audit")
    public List<Account> lancerAudit() {
        return accountService.auditComptesDangereux();
    }
}

class VirementRequest {
    private Long sourceId;
    private Long destId;
    private Double montant;

    public Long getSourceId() { return sourceId; }
    public void setSourceId(Long sourceId) { this.sourceId = sourceId; }

    public Long getDestId() { return destId; }
    public void setDestId(Long destId) { this.destId = destId; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
}