package com.leocentu.progettopersonale.service;

import com.leocentu.progettopersonale.model.Album;
import com.leocentu.progettopersonale.repository.AlbumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public void save(Album album) {
        this.albumRepository.save(album);
    }

    public List<Album> findAll() {
        return (List<Album>) this.albumRepository.findAll();
    }

    public int sommaVoti(List<Album> albumList) {
        int somma = 0;
        for (Album album : albumList) {
            somma += album.getVoto();
        }
        return somma;
    }

    public Album findById(Long id) {
        return this.albumRepository.findById(id).get();
    }
}