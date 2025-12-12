package com.realestate.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.Agent;
import com.realestate.app.model.Client;
import com.realestate.app.model.Contract;
import com.realestate.app.model.Property;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    
    // Trova tutti i contratti per proprietà
    List<Contract> findByProperty(Property property);
    
    // Trova tutti i contratti per agente
    List<Contract> findByAgent(Agent agent);
    
    // Trova tutti i contratti per cliente
    List<Contract> findByClient(Client client);
    
    // Trova tutti i contratti con data di inizio maggiore o uguale alla data specificata
    List<Contract> findByStartDateGreaterThanEqual(Date startDate);
    
    // Trova tutti i contratti con data di fine minore o uguale alla data specificata
    List<Contract> findByEndDateLessThanEqual(Date endDate);
    
    // Trova tutti i contratti con prezzo finale maggiore o uguale al valore specificato
    List<Contract> findByFinalPriceGreaterThanEqual(Double finalPrice);
    
    // Trova tutti i contratti per agente e con data di inizio maggiore o uguale alla data specificata
    List<Contract> findByAgentAndStartDateGreaterThanEqual(Agent agent, Date startDate);
    
    // Verifica se esiste un contratto con lo stesso ID
    boolean existsById(Long id);
}
