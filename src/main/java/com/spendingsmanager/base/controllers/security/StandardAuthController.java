package com.spendingsmanager.base.controllers.security;

import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.entities.Spender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class StandardAuthController {

    @Autowired
    private StandardUserService standardUserService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Spender spender, Map<String, Object> model) {
        List<Object> errors = new ArrayList<>();

        try {
            standardUserService.addUser(spender);
        } catch (Exception ex) {
            errors.add(ex.getMessage());
            model.put("errors", errors);
            return registration();
        }
        return "redirect:/login";
    }

    @RequestMapping({"/login"})
    public String loginPage(Map<String, Object> model) {
        return "login";
    }

    protected abstract StandardUserService getStandardUserService();
}
