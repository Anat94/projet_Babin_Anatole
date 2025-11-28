package com.example.projet_babin_anatole.repository;

import com.example.projet_babin_anatole.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String> {
}