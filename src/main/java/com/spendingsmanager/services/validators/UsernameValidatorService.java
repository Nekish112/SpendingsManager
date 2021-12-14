package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.services.validators.StandardValidator;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class UsernameValidatorService implements StandardValidator<String> {

    @Override
    public void validate(String object) {
        if (!(object != null && object.length() > 3 && object.length() < 20)) {
            throw new ValidationException("Incorrect Username: Username must be longer than 3 symbols and less than 20");
        }
    }
}
