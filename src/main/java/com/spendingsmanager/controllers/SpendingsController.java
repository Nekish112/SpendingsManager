package com.spendingsmanager.controllers;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.base.controllers.StandardEntityController;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.builders.SpendingsBuilder;
import com.spendingsmanager.entities.PaymentType;
import com.spendingsmanager.entities.Spending;
import com.spendingsmanager.entities.SpendingType;
import com.spendingsmanager.services.SpendingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/spendings")
public class SpendingsController extends StandardEntityController<Spending> {

    private static String VIEW_NAME = "spendings";

    @Autowired
    private SpendingsService spendingsService;

    @Autowired
    private SpendingsBuilder spendingsBuilder;

    @Override
    protected void initModelData(Map<String, Object> model) {
        model.put("paymentTypes", PaymentType.values());
        model.put("spendingTypes", SpendingType.values());
    }

    @Override
    protected String getViewName() {
        return VIEW_NAME;
    }

    @Override
    public StandardDomainService getStandardDomainService() {
        return spendingsService;
    }

    @Override
    public StandardBuilder getBuilder() {
        return spendingsBuilder;
    }
}
