package com.example.bankmanagement.service;

import com.example.bankmanagement.model.Compte;

import java.util.List;
import java.util.Optional;


public interface CompteService {
    Compte addCompte(Compte compte);
    Optional<Compte>findCompteById(Long id);
    List<Compte>getAllComptes();
}
