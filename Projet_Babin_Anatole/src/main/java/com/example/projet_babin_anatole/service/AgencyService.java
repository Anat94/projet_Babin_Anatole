package com.example.projet_babin_anatole.service;

import com.example.projet_babin_anatole.entity.Agency;
import com.example.projet_babin_anatole.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public Agency createAgency(Agency agency) {
        if (agency.getIdentification() == null || agency.getIdentification().length() != 5) {
            throw new RuntimeException("L'ID de l'agence doit etre une string de 5 chars.");
        }
        return agencyRepository.save(agency);
    }

    public List<Agency> listAllAgencies() {
        return agencyRepository.findAll();
    }
}