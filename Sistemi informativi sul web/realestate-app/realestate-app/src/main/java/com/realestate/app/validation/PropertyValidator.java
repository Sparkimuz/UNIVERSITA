package com.realestate.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.Property;

@Component
public class PropertyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Property.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Property property = (Property) target;
        
        // Validazione dell'indirizzo
        if (property.getAddress() == null || property.getAddress().trim().isEmpty()) {
            errors.rejectValue("address", "property.address.empty", "L'indirizzo è obbligatorio");
        }
        
        // Validazione della città
        if (property.getCity() == null || property.getCity().trim().isEmpty()) {
            errors.rejectValue("city", "property.city.empty", "La città è obbligatoria");
        }
        
        // Validazione del prezzo
        if (property.getPrice() == null) {
            errors.rejectValue("price", "property.price.empty", "Il prezzo è obbligatorio");
        } else if (property.getPrice() <= 0) {
            errors.rejectValue("price", "property.price.negative", "Il prezzo deve essere positivo");
        }
        
        // Validazione della dimensione
        if (property.getSize() == null) {
            errors.rejectValue("size", "property.size.empty", "La dimensione è obbligatoria");
        } else if (property.getSize() <= 0) {
            errors.rejectValue("size", "property.size.negative", "La dimensione deve essere positiva");
        }
        
        // Validazione del tipo
        if (property.getType() == null || property.getType().trim().isEmpty()) {
            errors.rejectValue("type", "property.type.empty", "Il tipo è obbligatorio");
        }
    }
}
