package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Spending;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class SpendingValidatorService implements StandardValidator<Spending> {

    private static final String INTERNAL_ERROR = "Internal error has occurred";

    private static final String PAYMENT_TYPE_ERROR = "Payment type is empty";

    private static final String AMOUNT_ERROR = "Amount is empty";

    private static final String DATE_ERROR = "Date is empty";

    private static final String SPENDING_TYPE_ERROR = "Spending type is empty";

    @Override
    public void validate(Spending object) {

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

        if (object.getSpendingType() == null) {
            errors.put("spendingTypeError", SPENDING_TYPE_ERROR);
        }

        if (errors != null && errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
