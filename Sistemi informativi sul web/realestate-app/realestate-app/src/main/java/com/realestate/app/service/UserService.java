package com.realestate.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.User;
import com.realestate.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Trova tutti gli utenti
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    // Trova un utente per ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Trova un utente per nome e cognome
    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // Verifica se esiste un utente con l'agente specificato
    public boolean existsByAgentId(Long agentId) {
        return userRepository.existsByAgentId(agentId);
    }

    // Salva un utente
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    // Aggiorna un utente
    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }

    // Elimina un utente per ID
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
