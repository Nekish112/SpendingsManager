package com.spendingsmanager.base.controllers.security;

import com.spendingsmanager.base.exceptions.ValidationException;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.entities.Spender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public String addUser(Spender spender, Model model) {
        try {
            standardUserService.addUser(spender);
        } catch (ValidationException ex) {
            System.out.println(ex.getMessage());
            model.addAllAttributes(ex.getErrors());
            return registration();
        }
        return "redirect:/login";
    }

    @RequestMapping({"/login"})
    public String loginPage(Model model) {
        return "login";
    }

    protected abstract StandardUserService getStandardUserService();
}
