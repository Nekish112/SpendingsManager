package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Counting;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.spendingsmanager.constants.ValidatorConstants.*;

@Service
public class CountingValidatorService implements StandardValidator<Counting> {

    @Override
    public void validate(Counting object) {
        Map<String, String> errors = new HashMap<>();

        if (object.getUser() == null) {
            errors.put("internalError", INTERNAL_ERROR);
        }

        if (object.getPaymentType() == null) {
            errors.put("paymentTypeError", PAYMENT_TYPE_ERROR);
        }

        if (object.getAmount() == null || object.getAmount().equals(BigDecimal.ZERO)) {
            errors.put("amountError", AMOUNT_ERROR);
        }

        if (object.getDate() == null) {
            errors.put("dateError", DATE_ERROR);
        }

        if (errors != null && errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
