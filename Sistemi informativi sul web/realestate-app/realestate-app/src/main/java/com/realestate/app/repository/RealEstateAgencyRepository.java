package com.realestate.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.RealEstateAgency;

@Repository
public interface RealEstateAgencyRepository extends JpaRepository<RealEstateAgency, Long> {
    
    // Trova tutte le agenzie per città
    List<RealEstateAgency> findByCity(String city);
    
    // Trova tutte le agenzie per indirizzo
    List<RealEstateAgency> findByAddress(String address);
    
    // Trova tutte le agenzie per città e indirizzo
    List<RealEstateAgency> findByCityAndAddress(String city, String address);
}
