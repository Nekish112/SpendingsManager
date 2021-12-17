package com.spendingsmanager.services;

import com.spendingsmanager.base.entities.security.User;
import com.spendingsmanager.base.repositories.StandardDomainRepository;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.entities.Counting;
//import com.spendingsmanager.repositories.CountingRepository;
import com.spendingsmanager.services.validators.CountingValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CountingService extends StandardDomainService<Counting> {

    @Autowired
    private SpenderService spenderService;

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
        return null;
    }

    @Override
    public List<Counting> findAllByUser(User user) {
        List<Counting> result = new ArrayList<>();

        result.addAll(incomeService.findAllByUser(user));
        result.addAll(spendingsService.findAllByUser(user));

        result.sort(Comparator.nullsFirst(Comparator.comparing(Counting::getDate, Comparator.nullsFirst(Comparator.naturalOrder())).reversed()));

        return result;
    }

    public List<Counting> filterByDate(String username, Date startDate, Date endDate) {
        User user = spenderService.findByUsername(username);

        List<Counting> result = findAllByUser(user);

        result = result
                .stream()
                .filter(obj -> obj != null && obj.getDate() != null && (startDate == null || obj.getDate().compareTo(startDate) >= 0))
                .filter(obj -> obj != null && obj.getDate() != null && (endDate == null || obj.getDate().compareTo(endDate) <= 0))
        .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Counting> findAllByUsername(String username) {
        List<Counting> result = new ArrayList<>();

        result.addAll(incomeService.findAllByUsername(username));
        result.addAll(spendingsService.findAllByUsername(username));

        result.sort(Comparator.nullsFirst(Comparator.comparing(Counting::getDate, Comparator.nullsFirst(Comparator.naturalOrder())).reversed()));

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
