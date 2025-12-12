package com.realestate.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.RealEstateAgency;
import com.realestate.app.repository.RealEstateAgencyRepository;

@Service
public class RealEstateAgencyService {

    @Autowired
    private RealEstateAgencyRepository realEstateAgencyRepository;

    // Trova tutte le agenzie
    public List<RealEstateAgency> findAll() {
        return realEstateAgencyRepository.findAll();
    }

    // Trova un'agenzia per ID
    public Optional<RealEstateAgency> findById(Long id) {
        return realEstateAgencyRepository.findById(id);
    }

    // Trova agenzie per città
    public List<RealEstateAgency> findByCity(String city) {
        return realEstateAgencyRepository.findByCity(city);
    }

    // Trova agenzie per indirizzo
    public List<RealEstateAgency> findByAddress(String address) {
        return realEstateAgencyRepository.findByAddress(address);
    }

    // Trova agenzie per città e indirizzo
    public List<RealEstateAgency> findByCityAndAddress(String city, String address) {
        return realEstateAgencyRepository.findByCityAndAddress(city, address);
    }

    // Salva un'agenzia
    @Transactional
    public RealEstateAgency save(RealEstateAgency agency) {
        return realEstateAgencyRepository.save(agency);
    }

    // Aggiorna un'agenzia
    @Transactional
    public RealEstateAgency update(RealEstateAgency agency) {
        return realEstateAgencyRepository.save(agency);
    }

    // Elimina un'agenzia per ID
    @Transactional
    public void deleteById(Long id) {
        realEstateAgencyRepository.deleteById(id);
    }
}
