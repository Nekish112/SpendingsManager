package com.spendingsmanager.services;

import com.spendingsmanager.base.repositories.StandardDomainRepository;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.repositories.IncomeRepository;
import com.spendingsmanager.entities.Income;
import com.spendingsmanager.services.validators.IncomeValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService extends StandardDomainService<Income> {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private SpenderService spenderService;

    @Autowired
    private IncomeValidatorService incomeValidatorService;

    @Override
    protected StandardUserService getStandardUserService() {
        return spenderService;
    }

    @Override
    protected StandardDomainRepository<Income> getRepository() {
        return incomeRepository;
    }

    @Override
    protected void validateBeforeSave(Income entity) {

    }
}
