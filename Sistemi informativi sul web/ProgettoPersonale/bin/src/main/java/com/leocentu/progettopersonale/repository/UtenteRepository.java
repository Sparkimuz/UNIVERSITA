package com.leocentu.progettopersonale.repository;

import org.springframework.data.repository.CrudRepository;


import com.leocentu.progettopersonale.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
    Utente findByCredenzialiUsername(String username);
}
