package com.spendingsmanager.services.security;

import com.spendingsmanager.entities.Role;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.services.SpenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegistrationService {

    static class RegistrationException extends Exception {
        public RegistrationException(String message) {
            super(message);
        }
    }

    @Autowired
    private SpenderService spenderService;

    public void addSpender(Spender spender) throws RegistrationException {
        Spender spenderFromDb = spenderService.findByUsername(spender.getUsername());

        if (spenderFromDb != null) {
            throw new RegistrationException("Spender is already exists!");
        }

        spender.setActive(true);
        spender.setRoles(Collections.singleton(Role.USER));
        spenderService.save(spender);
    }
}
