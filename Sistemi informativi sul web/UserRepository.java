package com.realestate.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Trova un utente per nome e cognome
    User findByFirstNameAndLastName(String firstName, String lastName);
    
    // Verifica se esiste un utente con l'agente specificato
    boolean existsByAgentId(Long agentId);
}
