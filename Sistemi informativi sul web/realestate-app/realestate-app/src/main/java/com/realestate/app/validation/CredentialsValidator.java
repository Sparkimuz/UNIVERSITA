package com.realestate.app.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.Credentials;
import com.realestate.app.service.CredentialsService;

@Component
public class CredentialsValidator implements Validator {

    @Autowired
    private CredentialsService credentialsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Credentials.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Credentials credentials = (Credentials) target;
        
        // Validazione dello username
        if (credentials.getUsername() == null || credentials.getUsername().trim().isEmpty()) {
            errors.rejectValue("username", "credentials.username.empty", "Lo username è obbligatorio");
        } else if (credentials.getId() == null && credentialsService.existsByUsername(credentials.getUsername())) {
            errors.rejectValue("username", "credentials.username.duplicate", "Username già in uso");
        }
        
        // Validazione della password
        if (credentials.getPassword() == null || credentials.getPassword().trim().isEmpty()) {
            errors.rejectValue("password", "credentials.password.empty", "La password è obbligatoria");
        } else if (credentials.getPassword().length() < 8) {
            errors.rejectValue("password", "credentials.password.tooShort", "La password deve essere di almeno 8 caratteri");
        }
        
        // Validazione del ruolo
        if (credentials.getRole() == null) {
            errors.rejectValue("role", "credentials.role.empty", "Il ruolo è obbligatorio");
        }
    }
}
