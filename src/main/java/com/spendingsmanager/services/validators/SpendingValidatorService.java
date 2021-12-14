package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Spending;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.math.BigDecimal;

@Service
public class SpendingValidatorService implements StandardValidator<Spending> {
    @Override
    public void validate(Spending object) {
        if (!(object.getSpender() != null && object.getPaymentType() != null && object.getAmount() != null
                && !object.getAmount().equals(BigDecimal.ZERO) && object.getDate() != null && object.getSpendingType() != null)) {
            throw new ValidationException("Incorrect spending data: check attributes for values");
        }
    }
}
