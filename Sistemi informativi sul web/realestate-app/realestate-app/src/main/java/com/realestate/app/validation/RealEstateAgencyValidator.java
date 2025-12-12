package com.realestate.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.RealEstateAgency;

@Component
public class RealEstateAgencyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RealEstateAgency.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RealEstateAgency agency = (RealEstateAgency) target;
        
        // Validazione dell'indirizzo
        if (agency.getAddress() == null || agency.getAddress().trim().isEmpty()) {
            errors.rejectValue("address", "agency.address.empty", "L'indirizzo è obbligatorio");
        }
        
        // Validazione della città
        if (agency.getCity() == null || agency.getCity().trim().isEmpty()) {
            errors.rejectValue("city", "agency.city.empty", "La città è obbligatoria");
        }
    }
}
