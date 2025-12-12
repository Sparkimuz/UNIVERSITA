package com.realestate.app.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.Client;

@Component
public class ClientValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        
        // Validazione del nome
        if (client.getFirstName() == null || client.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "client.firstName.empty", "Il nome è obbligatorio");
        }
        
        // Validazione del cognome
        if (client.getLastName() == null || client.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "client.lastName.empty", "Il cognome è obbligatorio");
        }
        
        // Validazione della data di nascita
        if (client.getBirth() == null) {
            errors.rejectValue("birth", "client.birth.empty", "La data di nascita è obbligatoria");
        } else {
            // Verifica che la data di nascita sia nel passato
            if (client.getBirth().after(new Date())) {
                errors.rejectValue("birth", "client.birth.future", "La data di nascita deve essere nel passato");
            }
            
            // Verifica che l'anno di nascita sia compreso tra 1900 e l'anno corrente
            Calendar cal = Calendar.getInstance();
            cal.setTime(client.getBirth());
            int birthYear = cal.get(Calendar.YEAR);
            
            if (birthYear < 1900 || birthYear > 2025) {
                errors.rejectValue("birth", "client.birth.invalidYear", "L'anno di nascita deve essere compreso tra 1900 e 2025");
            }
        }
    }
}
