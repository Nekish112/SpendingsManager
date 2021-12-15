package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsernameValidatorService implements StandardValidator<String> {

    private static final String USERNAME_ERROR = "Username must be more than 3 and less than 20 symbols";

    @Override
    public void validate(String object) {
        Map<String, String> errors = new HashMap<>();

        if (!(object != null && object.length() > 3 && object.length() < 20)) {
            errors.put("usernameError", USERNAME_ERROR);
        }

        if (errors != null && errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
