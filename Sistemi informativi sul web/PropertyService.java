package com.realestate.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realestate.app.model.Property;
import com.realestate.app.repository.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // Trova tutte le proprietà
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    // Trova una proprietà per ID
    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }

    // Trova proprietà per città
    public List<Property> findByCity(String city) {
        return propertyRepository.findByCity(city);
    }

    // Trova proprietà per tipo
    public List<Property> findByType(String type) {
        return propertyRepository.findByType(type);
    }

    // Trova proprietà con prezzo minore o uguale al valore specificato
    public List<Property> findByPriceLessThanEqual(Double price) {
        return propertyRepository.findByPriceLessThanEqual(price);
    }

    // Trova proprietà con dimensione maggiore o uguale al valore specificato
    public List<Property> findBySizeGreaterThanEqual(Double size) {
        return propertyRepository.findBySizeGreaterThanEqual(size);
    }

    // Trova proprietà per città e tipo
    public List<Property> findByCityAndType(String city, String type) {
        return propertyRepository.findByCityAndType(city, type);
    }

    // Trova proprietà per città e con prezzo minore o uguale al valore specificato
    public List<Property> findByCityAndPriceLessThanEqual(String city, Double price) {
        return propertyRepository.findByCityAndPriceLessThanEqual(city, price);
    }

    // Salva una proprietà
    @Transactional
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    // Aggiorna una proprietà
    @Transactional
    public Property update(Property property) {
        return propertyRepository.save(property);
    }

    // Elimina una proprietà per ID
    @Transactional
    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }
}
