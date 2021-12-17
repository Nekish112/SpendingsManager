package com.spendingsmanager.controllers;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.base.controllers.StandardEntityController;
import com.spendingsmanager.base.services.StandardDomainService;
import com.spendingsmanager.builders.CountingBuilder;
import com.spendingsmanager.entities.Counting;
import com.spendingsmanager.services.CountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
