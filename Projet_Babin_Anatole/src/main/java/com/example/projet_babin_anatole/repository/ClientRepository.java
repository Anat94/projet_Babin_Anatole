package com.example.projet_babin_anatole.repository;

import com.example.projet_babin_anatole.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}