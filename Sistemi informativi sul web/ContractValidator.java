package com.realestate.app.validation;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.realestate.app.model.Contract;

@Component
public class ContractValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        
        // Validazione della data di inizio
        if (contract.getStartDate() == null) {
            errors.rejectValue("startDate", "contract.startDate.empty", "La data di inizio è obbligatoria");
        }
        
        // Validazione della data di fine
        if (contract.getEndDate() == null) {
            errors.rejectValue("endDate", "contract.endDate.empty", "La data di fine è obbligatoria");
        } else if (contract.getStartDate() != null && contract.getEndDate().before(contract.getStartDate())) {
            errors.rejectValue("endDate", "contract.endDate.beforeStartDate", "La data di fine deve essere successiva alla data di inizio");
        }
        
        // Validazione del prezzo finale
        if (contract.getFinalPrice() == null) {
            errors.rejectValue("finalPrice", "contract.finalPrice.empty", "Il prezzo finale è obbligatorio");
        } else if (contract.getFinalPrice() <= 0) {
            errors.rejectValue("finalPrice", "contract.finalPrice.negative", "Il prezzo finale deve essere positivo");
        }
        
        // Validazione della proprietà
        if (contract.getProperty() == null) {
            errors.rejectValue("property", "contract.property.empty", "La proprietà è obbligatoria");
        }
        
        // Validazione dell'agente
        if (contract.getAgent() == null) {
            errors.rejectValue("agent", "contract.agent.empty", "L'agente è obbligatorio");
        }
        
        // Validazione del cliente
        if (contract.getClient() == null) {
            errors.rejectValue("client", "contract.client.empty", "Il cliente è obbligatorio");
        }
    }
}
