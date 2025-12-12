package com.realestate.app.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.Agent;

@Component
public class AgentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Agent.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Agent agent = (Agent) target;
        
        // Validazione del nome
        if (agent.getFirstName() == null || agent.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "agent.firstName.empty", "Il nome è obbligatorio");
        }
        
        // Validazione del cognome
        if (agent.getLastName() == null || agent.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "agent.lastName.empty", "Il cognome è obbligatorio");
        }
        
        // Validazione della data di nascita
        if (agent.getBirth() == null) {
            errors.rejectValue("birth", "agent.birth.empty", "La data di nascita è obbligatoria");
        } else {
            // Verifica che la data di nascita sia nel passato
            if (agent.getBirth().after(new Date())) {
                errors.rejectValue("birth", "agent.birth.future", "La data di nascita deve essere nel passato");
            }
            
            // Verifica che l'anno di nascita sia compreso tra 1900 e l'anno corrente
            Calendar cal = Calendar.getInstance();
            cal.setTime(agent.getBirth());
            int birthYear = cal.get(Calendar.YEAR);
            
            if (birthYear < 1900 || birthYear > 2025) {
                errors.rejectValue("birth", "agent.birth.invalidYear", "L'anno di nascita deve essere compreso tra 1900 e 2025");
            }
        }
    }
}
