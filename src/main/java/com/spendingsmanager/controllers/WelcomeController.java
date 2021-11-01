package com.spendingsmanager.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>SpendingsManagerTest</title></header>\n" +
                "<body>\n" + "Spendings Manager auto deploy test\n" + "</body>\n" + "</html>";
    }
}
