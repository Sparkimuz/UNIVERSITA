package com.realestate.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.Credentials;
import com.realestate.app.repository.CredentialsRepository;

@Service
public class CredentialsService {

    @Autowired
    private CredentialsRepository credentialsRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Trova tutte le credenziali
    public Iterable<Credentials> findAll() {
        return credentialsRepository.findAll();
    }

    // Trova credenziali per username
    public Credentials findByUsername(String username) {
        return credentialsRepository.findByUsername(username);
    }

    // Verifica se esiste un utente con lo username specificato
    public boolean existsByUsername(String username) {
        return credentialsRepository.existsByUsername(username);
    }

    // Salva credenziali con password codificata
    @Transactional
    public Credentials save(Credentials credentials) {
        credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        return credentialsRepository.save(credentials);
    }

    // Aggiorna credenziali
    @Transactional
    public Credentials update(Credentials credentials) {
        // Se la password è stata modificata, codificarla
        Credentials existingCredentials = credentialsRepository.findById(credentials.getId()).orElse(null);
        if (existingCredentials != null && !existingCredentials.getPassword().equals(credentials.getPassword())) {
            credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        }
        return credentialsRepository.save(credentials);
    }

    // Elimina credenziali per ID
    @Transactional
    public void deleteById(Long id) {
        credentialsRepository.deleteById(id);
    }
}
