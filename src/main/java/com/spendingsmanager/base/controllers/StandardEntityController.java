package com.spendingsmanager.base.controllers;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.base.entities.StandardEntity;
import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.StandardDomainService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public abstract class StandardEntityController<T extends StandardEntity> {

    protected void initModelData(Map<String, Object> model) {
    }

    protected abstract String getViewName();

    @GetMapping({"/"})
    public String getSpendings(Principal principal, Map<String, Object> model) {
        initModelData(model);
        puttingDataAtModel(model, principal);
        return getViewName();
    }

    @PostMapping({"/save"})
    public String saveEntity(Principal principal,
                             @ModelAttribute(name = "entity") T entity,
                             Map<String, Object> model) {
        try {
            getStandardDomainService().save(principal.getName(), entity);
        } catch (ValidationException ex) {
            System.out.println(ex.getMessage());
            model.putAll(ex.getErrors());
        }

        puttingDataAtModel(model, principal);

        return "redirect:";
    }

    private void puttingDataAtModel(Map<String, Object> model, Principal principal) {
        model.put("entity", getBuilder().build());
        try {
            List<T> entities = getStandardDomainService().findAllByUsername(principal.getName());
            model.put("entities", entities);
        } catch (ValidationException ex) {
            //TODO make a good logging
            System.out.println(ex.getMessage());
            model.putAll(ex.getErrors());
        }
    }

    public abstract StandardDomainService getStandardDomainService();

    public abstract StandardBuilder getBuilder();
}
