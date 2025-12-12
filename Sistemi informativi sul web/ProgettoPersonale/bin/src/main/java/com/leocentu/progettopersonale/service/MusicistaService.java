package com.leocentu.progettopersonale.service;

import com.leocentu.progettopersonale.model.Musicista;
import com.leocentu.progettopersonale.repository.MusicistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicistaService {
    @Autowired
    private MusicistaRepository musicistaRepository;

    public void save(Musicista musicista) {
        this.musicistaRepository.save(musicista);
    }

    public List<Musicista> findAll() {
        return (List<Musicista>) this.musicistaRepository.findAll();
    }

    public Musicista findByCredenzialiUsername(String username) {
        return this.musicistaRepository.findByCredenzialiUsername(username);
    }

    public Musicista findById(Long id) {
        return this.musicistaRepository.findById(id).orElse(null);
    }
}