package com.spendingsmanager.controllers;

import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.entities.Role;
import com.spendingsmanager.entities.Spender;
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

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addSpender(Spender spender, Map<String, Object> model) {
        List<Object> errors = new ArrayList<>();

        Spender spenderFromDb = spenderRepository.findByUsername(spender.getUsername());

        if (spenderFromDb != null) {
            errors.add("Spender exists!");
            model.put("errors", errors);
            return registration();
        }

        spender.setActive(true);
        spender.setRoles(Collections.singleton(Role.USER));
        spenderRepository.save(spender);

        return "redirect:/login";
    }

    @RequestMapping({"/login"})
    public String loginPage(Map<String, Object> model) {
        return "login";
    }
}
