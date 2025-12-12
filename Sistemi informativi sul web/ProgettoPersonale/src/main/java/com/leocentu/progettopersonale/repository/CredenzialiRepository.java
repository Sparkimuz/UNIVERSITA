package com.leocentu.progettopersonale.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.leocentu.progettopersonale.model.Credenziali;

public interface CredenzialiRepository extends CrudRepository<Credenziali, Long> {
     boolean existsByUsername(String username);

    @Query("SELECT c.id FROM Credenziali c WHERE c.username = :username")
    public Long findIdByUsername(String username);
}
