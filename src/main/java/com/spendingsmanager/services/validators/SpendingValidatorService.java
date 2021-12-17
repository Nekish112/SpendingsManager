package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Spending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.spendingsmanager.constants.ValidatorConstants.*;

@Service
public class SpendingValidatorService implements StandardValidator<Spending> {

    @Autowired
    private CountingValidatorService countingValidatorService;

    @Override
    public void validate(Spending object) {

        Map<String, String> errors = new HashMap<>();

        try {
            countingValidatorService.validate(object);
        } catch (ValidationException ex) {
            errors.putAll(ex.getErrors());
        }

        if (object.getSpendingType() == null) {
            errors.put("spendingTypeError", SPENDING_TYPE_ERROR);
        }

        if (errors != null && errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
