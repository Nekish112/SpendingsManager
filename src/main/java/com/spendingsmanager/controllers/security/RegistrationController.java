package com.spendingsmanager.controllers.security;

import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.entities.Role;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.services.security.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class RegistrationController {

    @Autowired
    private SpenderRepository spenderRepository;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addSpender(Spender spender, Map<String, Object> model) {
        List<Object> errors = new ArrayList<>();

        try {
            registrationService.addSpender(spender);
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
}
