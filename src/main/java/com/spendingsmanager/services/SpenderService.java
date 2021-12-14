package com.spendingsmanager.services;

import com.spendingsmanager.base.repositories.security.StandardUserRepository;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.base.services.validators.StandardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SpenderService extends StandardUserService<Spender> {
    @Autowired
    private SpenderRepository spenderRepository;

    @Autowired
    private StandardValidator spenderValidatorService;

    @Autowired
    private StandardValidator usernameValidatorService;

    @Override
    public Spender findByUsername(String username) {
        usernameValidatorService.validate(username);
        Spender resultSpender = spenderRepository.findByUsername(username);
        return resultSpender;
    }

    @Override
    protected void validateBeforeSearch(String entity) {
        usernameValidatorService.validate(entity);
    }

    @Override
    protected StandardUserRepository<Spender> getRepository() {
        return spenderRepository;
    }

    @Override
    protected void validateBeforeSave(Spender entity) {
        spenderValidatorService.validate(entity);
    }
}
