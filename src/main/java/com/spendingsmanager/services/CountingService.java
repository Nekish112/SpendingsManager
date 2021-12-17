package com.spendingsmanager.services;

import com.spendingsmanager.base.entities.security.User;
import com.spendingsmanager.base.repositories.StandardDomainRepository;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.entities.Counting;
import com.spendingsmanager.repositories.CountingRepository;
import com.spendingsmanager.services.validators.CountingValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CountingService extends StandardDomainService<Counting> {

    @Autowired
    private SpenderService spenderService;

    @Autowired
    private CountingRepository countingRepository;

    @Autowired
    private CountingValidatorService countingValidatorService;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private SpendingsService spendingsService;

    @Override
    protected StandardUserService getStandardUserService() {
        return spenderService;
    }

    @Override
    protected StandardDomainRepository getRepository() {
        return countingRepository;
    }

    @Override
    public List<Counting> findAllByUser(User user) {
        List<Counting> result = new ArrayList<>();

        result.addAll(incomeService.findAllByUser(user));
        result.addAll(spendingsService.findAllByUser(user));

        result.sort(Comparator.comparing(Counting::getDate).reversed());

        return result;
    }

    @Override
    public List<Counting> findAllByUsername(String username) {
        List<Counting> result = new ArrayList<>();

        result.addAll(incomeService.findAllByUsername(username));
        result.addAll(spendingsService.findAllByUsername(username));

        result.sort(Comparator.comparing(Counting::getDate).reversed());

        return result;
    }

    @Override
    public void save(String username, Counting entity) {
        return;
    }

    @Override
    protected void validateBeforeSave(Counting entity) {
        countingValidatorService.validate(entity);
    }
}
