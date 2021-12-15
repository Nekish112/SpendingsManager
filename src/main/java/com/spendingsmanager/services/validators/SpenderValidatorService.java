package com.spendingsmanager.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.validators.StandardValidator;
import com.spendingsmanager.entities.Spender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SpenderValidatorService implements StandardValidator<Spender> {

    // TODO move to const class
    private static final String USERNAME_ERROR = "Username must be more than 3 and less than 20 symbols";

    private static final String LOGIN_ERROR = "Login must be more than 3 and less than 20 symbols";

    private static final String PASSWORD_ERROR = "Password must be more than 6 and less than 20 symbols";

    private static final String FULL_NAME_ERROR = "Full name must be more than 10 and less than 50 symbols";

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
