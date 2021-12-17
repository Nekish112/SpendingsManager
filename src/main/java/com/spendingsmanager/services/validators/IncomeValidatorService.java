package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.spendingsmanager.constants.ValidatorConstants.*;

@Service
public class IncomeValidatorService implements StandardValidator<Income> {

    @Autowired
    private CountingValidatorService countingValidatorService;

    @Override
    public void validate(Income object) {
        Map<String, String> errors = new HashMap<>();

        try {
            countingValidatorService.validate(object);
        } catch (ValidationException ex) {
            errors.putAll(ex.getErrors());
        }

        if (object.getIncomeType() == null) {
            errors.put("incomeTypeError", INCOME_TYPE_ERROR);
        }

        if (errors != null && errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
