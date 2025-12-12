package com.realestate.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.Agent;
import com.realestate.app.model.RealEstateAgency;
import com.realestate.app.repository.AgentRepository;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    // Trova tutti gli agenti
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    // Trova un agente per ID
    public Optional<Agent> findById(Long id) {
        return agentRepository.findById(id);
    }

    // Trova agenti per nome e cognome
    public List<Agent> findByFirstNameAndLastName(String firstName, String lastName) {
        return agentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // Trova agenti per data di nascita
    public List<Agent> findByBirth(Date birth) {
        return agentRepository.findByBirth(birth);
    }

    // Trova agenti per agenzia
    public List<Agent> findByAgency(RealEstateAgency agency) {
        return agentRepository.findByAgency(agency);
    }

    // Verifica se esiste un agente con nome, cognome e data di nascita specificati
    public boolean existsByFirstNameAndLastNameAndBirth(String firstName, String lastName, Date birth) {
        return agentRepository.existsByFirstNameAndLastNameAndBirth(firstName, lastName, birth);
    }

    // Salva un agente
    @Transactional
    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    // Aggiorna un agente
    @Transactional
    public Agent update(Agent agent) {
        return agentRepository.save(agent);
    }

    // Elimina un agente per ID
    @Transactional
    public void deleteById(Long id) {
        agentRepository.deleteById(id);
    }
}
