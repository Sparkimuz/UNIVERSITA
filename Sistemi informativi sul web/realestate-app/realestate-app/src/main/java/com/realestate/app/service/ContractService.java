package com.realestate.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.Agent;
import com.realestate.app.model.Client;
import com.realestate.app.model.Contract;
import com.realestate.app.model.Property;
import com.realestate.app.repository.ContractRepository;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    // Trova tutti i contratti
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    // Trova un contratto per ID
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    // Trova contratti per proprietà
    public List<Contract> findByProperty(Property property) {
        return contractRepository.findByProperty(property);
    }

    // Trova contratti per agente
    public List<Contract> findByAgent(Agent agent) {
        return contractRepository.findByAgent(agent);
    }

    // Trova contratti per cliente
    public List<Contract> findByClient(Client client) {
        return contractRepository.findByClient(client);
    }

    // Trova contratti con data di inizio maggiore o uguale alla data specificata
    public List<Contract> findByStartDateGreaterThanEqual(Date startDate) {
        return contractRepository.findByStartDateGreaterThanEqual(startDate);
    }

    // Trova contratti con data di fine minore o uguale alla data specificata
    public List<Contract> findByEndDateLessThanEqual(Date endDate) {
        return contractRepository.findByEndDateLessThanEqual(endDate);
    }

    // Trova contratti con prezzo finale maggiore o uguale al valore specificato
    public List<Contract> findByFinalPriceGreaterThanEqual(Double finalPrice) {
        return contractRepository.findByFinalPriceGreaterThanEqual(finalPrice);
    }

    // Trova contratti per agente e con data di inizio maggiore o uguale alla data specificata
    public List<Contract> findByAgentAndStartDateGreaterThanEqual(Agent agent, Date startDate) {
        return contractRepository.findByAgentAndStartDateGreaterThanEqual(agent, startDate);
    }

    // Verifica se esiste un contratto con lo stesso ID
    public boolean existsById(Long id) {
        return contractRepository.existsById(id);
    }

    // Salva un contratto
    @Transactional
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    // Aggiorna un contratto
    @Transactional
    public Contract update(Contract contract) {
        return contractRepository.save(contract);
    }

    // Elimina un contratto per ID
    @Transactional
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
