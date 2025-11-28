package com.example.projet_babin_anatole.service;

import com.example.projet_babin_anatole.entity.Agency;
import com.example.projet_babin_anatole.entity.Advisor;
import com.example.projet_babin_anatole.repository.AgencyRepository;
import com.example.projet_babin_anatole.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdvisorService {

    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    public Advisor createAdvisor(Advisor advisor, String agenceId) {
        Agency agency = agencyRepository.findById(agenceId)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        advisor.setAgency(agency);
        return advisorRepository.save(advisor);
    }

    public List<Advisor> listAllAdvisor() {
        return advisorRepository.findAll();
    }
}