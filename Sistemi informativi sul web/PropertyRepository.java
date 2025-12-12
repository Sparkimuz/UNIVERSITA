package com.realestate.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    
    // Trova tutte le proprietà per città
    List<Property> findByCity(String city);
    
    // Trova tutte le proprietà per tipo
    List<Property> findByType(String type);
    
    // Trova tutte le proprietà con prezzo minore o uguale al valore specificato
    List<Property> findByPriceLessThanEqual(Double price);
    
    // Trova tutte le proprietà con dimensione maggiore o uguale al valore specificato
    List<Property> findBySizeGreaterThanEqual(Double size);
    
    // Trova tutte le proprietà per città e tipo
    List<Property> findByCityAndType(String city, String type);
    
    // Trova tutte le proprietà per città e con prezzo minore o uguale al valore specificato
    List<Property> findByCityAndPriceLessThanEqual(String city, Double price);
}
