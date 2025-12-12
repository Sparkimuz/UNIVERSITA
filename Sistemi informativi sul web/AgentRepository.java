package com.realestate.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.Agent;
import com.realestate.app.model.RealEstateAgency;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    
    // Trova tutti gli agenti per nome e cognome
    List<Agent> findByFirstNameAndLastName(String firstName, String lastName);
    
    // Trova tutti gli agenti per data di nascita
    List<Agent> findByBirth(Date birth);
    
    // Trova tutti gli agenti per agenzia
    List<Agent> findByAgency(RealEstateAgency agency);
    
    // Verifica se esiste un agente con nome, cognome e data di nascita specificati
    boolean existsByFirstNameAndLastNameAndBirth(String firstName, String lastName, Date birth);
}
