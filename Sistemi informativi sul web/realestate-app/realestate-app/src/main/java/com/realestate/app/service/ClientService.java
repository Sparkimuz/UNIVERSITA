package com.realestate.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.Client;
import com.realestate.app.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Trova tutti i clienti
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    // Trova un cliente per ID
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    // Trova clienti per nome e cognome
    public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
        return clientRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // Trova clienti per data di nascita
    public List<Client> findByBirth(Date birth) {
        return clientRepository.findByBirth(birth);
    }

    // Verifica se esiste un cliente con nome e cognome specificati
    public boolean existsByFirstNameAndLastName(String firstName, String lastName) {
        return clientRepository.existsByFirstNameAndLastName(firstName, lastName);
    }

    // Salva un cliente
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    // Aggiorna un cliente
    @Transactional
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    // Elimina un cliente per ID
    @Transactional
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
