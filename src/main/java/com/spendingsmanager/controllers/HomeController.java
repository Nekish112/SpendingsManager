package com.spendingsmanager.controllers;

import com.spendingsmanager.base.controllers.StandardEntityController;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.entities.PaymentType;
import com.spendingsmanager.entities.Spending;
import com.spendingsmanager.entities.SpendingType;
import com.spendingsmanager.services.SpendingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Map;

@Controller
public class HomeController extends StandardEntityController<Spending> {

    private static String VIEW_NAME = "index";

    @Autowired
    private SpendingsService spendingsService;

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
}
