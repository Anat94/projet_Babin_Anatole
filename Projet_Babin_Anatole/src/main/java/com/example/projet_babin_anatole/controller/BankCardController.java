package com.example.projet_babin_anatole.controller;

import com.example.projet_babin_anatole.entity.BankCard;
import com.example.projet_babin_anatole.entity.Client;
import com.example.projet_babin_anatole.entity.CardType;
import com.example.projet_babin_anatole.service.BankCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion des CB", description = "Endpoints pour la gestion des cb")
@RestController
@RequestMapping("/cards")
public class BankCardController {

    @Autowired
    private BankCardService carteService;

    @Operation(summary = "Attribuer une card", description = "Endpoint pour attribuer une card a un client.")
    @ApiResponse(responseCode = "200", description = "CB attribue avec succès")
    @PostMapping
    public BankCard setCard(@RequestParam Long clientId, @RequestParam CardType type) {
        return carteService.setCard(clientId, type);
    }

    @Operation(summary = "Lister les cartes", description = "Endpoint pour lister les cartes bleues.")
    @ApiResponse(responseCode = "200", description = "Liste des CB")
    @GetMapping
    public List<BankCard> getAllCards() {
        return carteService.getAllCards();
    }
}