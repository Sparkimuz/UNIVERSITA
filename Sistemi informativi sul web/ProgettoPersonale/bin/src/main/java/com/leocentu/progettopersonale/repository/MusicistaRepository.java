package com.leocentu.progettopersonale.repository;

import org.springframework.data.repository.CrudRepository;

import com.leocentu.progettopersonale.model.Musicista;

import java.util.Optional;

public interface MusicistaRepository extends CrudRepository<Musicista, Long> {
    public Musicista findByCredenzialiUsername(String username);
}