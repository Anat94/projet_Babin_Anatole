package com.example.projet_babin_anatole.controller;

import com.example.projet_babin_anatole.entity.Agency;
import com.example.projet_babin_anatole.service.AgencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Gestion des agences", description = "Endpoints pour la gestion des agences")
@RestController
@RequestMapping("/agencies")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @Operation(summary = "Créer une agence", description = "Endpoint pour creer une angence")
    @ApiResponse(responseCode = "200", description = "Agence créé avec succès")
    @PostMapping
    public Agency createAgency(@RequestBody Agency agency) {
        return agencyService.createAgency(agency);
    }

    @Operation(summary = "Liste des agences", description = "Endpoint pour listes des angences")
    @ApiResponse(responseCode = "200", description = "Agence listes avec succès")
    @GetMapping
    public List<Agency> listAgencies() {
        return agencyService.listAllAgencies();
    }
}