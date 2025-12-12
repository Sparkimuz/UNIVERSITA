package com.leocentu.progettopersonale.service;

import com.leocentu.progettopersonale.model.Credenziali;

import com.leocentu.progettopersonale.model.Votazione;
import com.leocentu.progettopersonale.repository.CredenzialiRepository;
import com.leocentu.progettopersonale.repository.VotazioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotazioneService {
    @Autowired
    private VotazioneRepository votazioneRepository;

    public List<Votazione> findAll() {
        return (List<Votazione>) this.votazioneRepository.findAll();
    }

    public void save(Votazione votazione) {
        this.votazioneRepository.save(votazione);
    }

    public void delete(Votazione votazione) {
        this.votazioneRepository.delete(votazione);
    }
}
