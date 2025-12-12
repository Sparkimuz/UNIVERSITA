package com.leocentu.progettopersonale.repository;

import org.springframework.data.repository.CrudRepository;

import com.leocentu.progettopersonale.model.Credenziali;
import com.leocentu.progettopersonale.model.Votazione;

public interface VotazioneRepository extends CrudRepository<Votazione, Long> {
}
