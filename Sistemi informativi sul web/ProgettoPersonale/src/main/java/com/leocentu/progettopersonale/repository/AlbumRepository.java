package com.leocentu.progettopersonale.repository;

import org.springframework.data.repository.CrudRepository;

import com.leocentu.progettopersonale.model.Album;
import com.leocentu.progettopersonale.model.Utente;

public interface AlbumRepository extends CrudRepository<Album, Long> {
}