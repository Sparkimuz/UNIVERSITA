package com.realestate.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    // Trova tutti i clienti per nome e cognome
    List<Client> findByFirstNameAndLastName(String firstName, String lastName);
    
    // Trova tutti i clienti per data di nascita
    List<Client> findByBirth(Date birth);
    
    // Verifica se esiste un cliente con nome e cognome specificati
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
