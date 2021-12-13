package com.spendingsmanager.services.validators;

import com.spendingsmanager.entities.Spender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class SpenderValidatorService implements StandardValidator<Spender> {
    @Autowired
    private StandardValidator usernameValidatorService;
    @Override
    public void validate(Spender object) {
        usernameValidatorService.validate(object.getUsername());

        if (!(object.getLogin() != null && object.getLogin().length() > 3 && object.getLogin().length() < 20
            && object.getPassword() != null && object.getPassword().length() > 6 && object.getPassword().length() < 20
            && object.getFullName() != null && object.getFullName().length() > 10 && object.getFullName().length() < 50)) {
            throw new ValidationException("Incorrect Spender data: check attributes for values");
        }
    }
}
