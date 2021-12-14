package com.spendingsmanager.controllers.security;

import com.spendingsmanager.base.controllers.security.StandardAuthController;
import com.spendingsmanager.base.services.StandardUserService;
import com.spendingsmanager.services.SpenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController extends StandardAuthController {

    @Autowired
    private SpenderService spenderService;

    @Override
    protected StandardUserService getStandardUserService() {
        return spenderService;
    }
}
