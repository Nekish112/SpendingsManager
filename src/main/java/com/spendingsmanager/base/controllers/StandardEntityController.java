package com.spendingsmanager.base.controllers;

import com.spendingsmanager.base.entities.StandardEntity;
import com.spendingsmanager.base.services.StandardDomainService;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
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
        try {
            List<T> entities = getStandardDomainService().findAllByUsername(principal.getName());
            model.put("entities", entities);
        } catch (ValidationException ex) {
            model.put("entitiesException", ex.getMessage());
        }

        return getViewName();
    }

    @PostMapping({"/"})
    @ResponseBody
    public void saveSpending(Principal principal,
                             @RequestBody T entity,
                             Map<String, Object> model) {
        try {
            getStandardDomainService().save(principal.getName(), entity);
        } catch (ValidationException ex) {
            model.put("saveEntityException", ex.getMessage());
        }
    }

    public abstract StandardDomainService getStandardDomainService();
}