package com.realestate.app.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.User;
import com.realestate.app.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        // Validazione del nome
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "user.firstName.empty", "Il nome è obbligatorio");
        }
        
        // Validazione del cognome
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "user.lastName.empty", "Il cognome è obbligatorio");
        }
        
        // Validazione della data di nascita
        if (user.getBirth() == null) {
            errors.rejectValue("birth", "user.birth.empty", "La data di nascita è obbligatoria");
        } else {
            // Verifica che la data di nascita sia nel passato
            if (user.getBirth().after(new Date())) {
                errors.rejectValue("birth", "user.birth.future", "La data di nascita deve essere nel passato");
            }
            
            // Verifica che l'anno di nascita sia compreso tra 1900 e l'anno corrente
            Calendar cal = Calendar.getInstance();
            cal.setTime(user.getBirth());
            int birthYear = cal.get(Calendar.YEAR);
            
            if (birthYear < 1900 || birthYear > 2025) {
                errors.rejectValue("birth", "user.birth.invalidYear", "L'anno di nascita deve essere compreso tra 1900 e 2025");
            }
        }
    }
}
