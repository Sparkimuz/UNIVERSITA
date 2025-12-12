package com.leocentu.progettopersonale.service;

import com.leocentu.progettopersonale.model.Utente;

import com.leocentu.progettopersonale.repository.UtenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void save(Utente utente) {
        this.utenteRepository.save(utente);
    }

    public Utente findByCredenzialiUsername(String username) {
        return this.utenteRepository.findByCredenzialiUsername(username);
    }
}
