package com.spendingsmanager.services;

import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.base.services.validators.StandardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpenderService {
    @Autowired
    private SpenderRepository spenderRepository;

    @Autowired
    private StandardValidator spenderValidatorService;

    @Autowired
    private StandardValidator usernameValidatorService;

    public Spender findByUsername(String username) {
        usernameValidatorService.validate(username);
        Spender resultSpender = spenderRepository.findByUsername(username);
        return resultSpender;
    }

    public void save(Spender object) {
        spenderValidatorService.validate(object);
        spenderRepository.save(object);
    }
}
