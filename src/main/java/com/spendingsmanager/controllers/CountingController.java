package com.spendingsmanager.controllers;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.base.controllers.StandardEntityController;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.builders.CountingBuilder;
import com.spendingsmanager.entities.Counting;
import com.spendingsmanager.services.CountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CountingController extends StandardEntityController<Counting> {

    @Autowired
    private CountingService countingService;

    @Autowired
    private CountingBuilder countingBuilder;

    @Override
    protected String getViewName() {
        return "index";
    }

    @Override
    public StandardDomainService getStandardDomainService() {
        return countingService;
    }

    @Override
    public StandardBuilder getBuilder() {
        return countingBuilder;
    }

    @PostMapping({"/filter"})
    public String saveEntity(Principal principal,
                             @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                             @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                             Map<String, Object> model) {


        List<Counting> result = countingService.filterByDate(principal.getName(), startDate, endDate);

        model.put("entities", result);
        model.put("startDate", startDate);
        model.put("endDate", endDate);

        BigDecimal amount = new BigDecimal(0);

        for (Counting counting : result) {
            if (counting.getAmount() != null) {
                amount = amount.add(counting.getAmount());
            }
        }

        model.put("overallAmount", amount);

        return getViewName();
    }

    @Override
    public String getEntities(Principal principal, Map<String, Object> model) {
        String result = super.getEntities(principal, model);
        List<Counting> countingList = (List<Counting>) model.get("entities");

        BigDecimal amount = new BigDecimal(0);

        if (countingList != null) {
            for (Counting counting : countingList) {
                if (counting.getAmount() != null) {
                    amount = amount.add(counting.getAmount());
                }
            }
        }

        model.put("overallAmount", amount);

        return result;
    }
}
