package com.spendingsmanager.services;

import com.spendingsmanager.dao.SpendingRepository;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.entities.Spending;
import com.spendingsmanager.base.services.validators.StandardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendingsService {
    
    @Autowired
    private SpendingRepository spendingRepository;
    
    @Autowired
    private SpenderService spenderService;

    @Autowired
    private StandardValidator spendingValidatorService;
    
    public List<Spending> findByUsername(String username) {

        List<Spending> spendings = null;
        
        Spender spender = spenderService.findByUsername(username);
        
        if (spender != null) {
            spendings = spendingRepository.findBySpender(spender);
        }
        
        return spendings;
    }

    public void save(String username, String spendingType,
                     String spendingAmount, String paymentType, String spendingDate) {
        Spender spender = spenderService.findByUsername(username);

        Spending spending = new Spending(spender, paymentType,
                spendingType, spendingDate, spendingAmount);

        spendingValidatorService.validate(spending);

        spendingRepository.save(spending);
    }
}
