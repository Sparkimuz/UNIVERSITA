package com.realestate.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    
    // Trova le credenziali per username
    Credentials findByUsername(String username);
    
    // Verifica se esiste un utente con lo username specificato
    boolean existsByUsername(String username);
}
