package com.example.bankmanagement.service;

import com.example.bankmanagement.model.Compte;
import com.example.bankmanagement.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiveImpl implements CompteService{

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte addCompte(Compte compte) {
        return this.compteRepository.save(compte);
    }

    @Override
    public Optional<Compte> findCompteById(Long id) {
        return this.compteRepository.findById(id);
    }
    @Override
    public List<Compte> getAllComptes() {
        return this.compteRepository.findAll();
    }
}
