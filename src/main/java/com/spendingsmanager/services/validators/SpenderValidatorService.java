package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Spender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.spendingsmanager.constants.ValidatorConstants.*;

@Service
public class SpenderValidatorService implements StandardValidator<Spender> {

    @Override
    public void validate(Spender object) {
        Map<String, String> errors = new HashMap<>();

        if (!(object.getUsername() != null && object.getUsername().length() > 3 && object.getUsername().length() < 20)) {
            errors.put("usernameError", USERNAME_ERROR);
        }

        if (!(object.getLogin() != null && object.getLogin().length() > 3 && object.getLogin().length() < 20)) {
            errors.put("loginError", LOGIN_ERROR);
        }

        if (!(object.getPassword() != null && object.getPassword().length() > 6 && object.getPassword().length() < 20)) {
            errors.put("passwordError", PASSWORD_ERROR);
        }

        if (!(object.getFullName() != null && object.getFullName().length() > 10 && object.getFullName().length() < 50)) {
            errors.put("fullNameError", FULL_NAME_ERROR);
        }

        if (errors != null && errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
