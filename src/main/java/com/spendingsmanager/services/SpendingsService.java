package com.spendingsmanager.services;

import com.spendingsmanager.base.repositories.StandardDomainRepository;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.dao.SpendingRepository;
import com.spendingsmanager.base.services.validators.StandardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendingsService extends StandardDomainService {
    
    @Autowired
    private SpendingRepository spendingRepository;
    
    @Autowired
    private SpenderService spenderService;

    @Autowired
    private StandardValidator spendingValidatorService;

    @Override
    protected StandardUserService getStandardUserService() {
        return spenderService;
    }

    @Override
    protected StandardDomainRepository getRepository() {
        return spendingRepository;
    }

    @Override
    protected void validateBeforeSave(Object entity) {
        spendingValidatorService.validate(entity);
    }
}
