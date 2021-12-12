package com.spendingsmanager.controllers;

import com.spendingsmanager.dao.SpenderRepository;
import com.spendingsmanager.dao.SpendingRepository;
import com.spendingsmanager.entities.PaymentType;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.entities.Spending;
import com.spendingsmanager.entities.SpendingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private SpenderRepository spenderRepository;

    @Autowired
    private SpendingRepository spendingRepository;

    @GetMapping({"/"})
    public String welcomeAsHTML(Principal principal, Map<String, Object> model) {
        model.put("paymentTypes", PaymentType.values());
        model.put("spendingTypes", SpendingType.values());

        Spender spender = spenderRepository.findByUsername(principal.getName());

        List<Spending> spendings = spendingRepository.findBySpender(spender);

        model.put("spendings", spendings);

        return "index";
    }

    @PostMapping({"/"})
    @ResponseBody
    public void saveSpending(Principal principal,
                             @RequestParam("spendingType") String spendingType,
                             @RequestParam("amount") String spendingAmount,
                             @RequestParam("paymentType") String paymentType,
                             @RequestParam("date") String spendingDate) throws ParseException {
        Spender spender = spenderRepository.findByUsername(principal.getName());

        Spending spending = new Spending(spender, paymentType,
                spendingType, spendingDate, spendingAmount);

        spendingRepository.save(spending);
    }
}