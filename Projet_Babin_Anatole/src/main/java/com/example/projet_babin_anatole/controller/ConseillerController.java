package com.example.projet_babin_anatole.controller;

import com.example.projet_babin_anatole.entity.Advisor;
import com.example.projet_babin_anatole.service.AdvisorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "Gestion des conseillers", description = "Endpoints pour la gestion des conseillers")
@RequestMapping("/advisor")
public class ConseillerController {

    @Autowired
    private AdvisorService advisorService;

    @Operation(summary = "Créer un advisor", description = "Endpoint pour ajouter un advisor.")
    @ApiResponse(responseCode = "200", description = "Advisor créé avec succès")
    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor, @RequestParam String agenceId) {
        return advisorService.createAdvisor(advisor, agenceId);
    }

    @Operation(summary = "Récupérer les conseillers", description = "Endpoint pour récupérer tous les conseillers.")
    @ApiResponse(responseCode = "200", description = "Tous les conseillers")
    @GetMapping
    public List<Advisor> lireConseillers() {
        return advisorService.listAllAdvisor();
    }
}