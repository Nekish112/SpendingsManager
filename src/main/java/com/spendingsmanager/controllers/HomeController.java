package com.spendingsmanager.controllers;

import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.dao.SpendingRepository;
import com.spendingsmanager.entities.PaymentType;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.entities.Spending;
import com.spendingsmanager.entities.SpendingType;
import com.spendingsmanager.services.SpendingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.validator.ValidatorException;

import javax.validation.ValidationException;
import java.math.BigDecimal;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private SpendingsService spendingsService;

    @GetMapping({"/"})
    public String getSpendings(Principal principal, Map<String, Object> model) {
        model.put("paymentTypes", PaymentType.values());
        model.put("spendingTypes", SpendingType.values());
        try {
            List<Spending> spendings = spendingsService.findByUsername(principal.getName());
            model.put("spendings", spendings);
        } catch (ValidationException ex) {
            model.put("spendingsException", ex.getMessage());
        }

        return "index";
    }

    @PostMapping({"/"})
    @ResponseBody
    public void saveSpending(Principal principal,
                             @RequestParam("spendingType") String spendingType,
                             @RequestParam("amount") String spendingAmount,
                             @RequestParam("paymentType") String paymentType,
                             @RequestParam("date") String spendingDate,
                             Map<String, Object> model) {
        try {
            spendingsService.save(principal.getName(), spendingType, spendingAmount, paymentType, spendingDate);
        } catch (ValidationException ex) {
            model.put("saveSpendingException", ex.getMessage());
        }
    }
}
