package com.spendingsmanager.controllers;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.base.controllers.StandardEntityController;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.builders.IncomeBuilder;
import com.spendingsmanager.entities.Income;
import com.spendingsmanager.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/income")
public class IncomeController extends StandardEntityController<Income> {

    private static String VIEW_NAME = "income";

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private IncomeBuilder incomeBuilder;

    @Override
    protected String getViewName() {
        return VIEW_NAME;
    }

    @Override
    public StandardDomainService getStandardDomainService() {
        return incomeService;
    }

    @Override
    public StandardBuilder getBuilder() {
        return incomeBuilder;
    }
}
