package com.spendingsmanager.services;

import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.services.validators.StandardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpenderService {
    @Autowired
    private SpenderRepository spenderRepository;

    @Autowired
    private StandardValidator usernameValidatorService;

    Spender findByUsername(String username) {
        usernameValidatorService.validate(username);
        Spender resultSpender = spenderRepository.findByUsername(username);
        return resultSpender;
    }
}
