package com.spendingsmanager.services;

import com.spendingsmanager.dao.SpendingRepository;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.entities.Spending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendingsService {
    
    @Autowired
    private SpendingRepository spendingRepository;
    
    @Autowired
    private SpenderService spenderService;
    
    public List<Spending> findByUsername(String username) {

        List<Spending> spendings = null;
        
        Spender spender = spenderService.findByUsername(username);
        
        if (spender != null) {
            spendings = spendingRepository.findBySpender(spender);
        }
        
        return spendings;
    }
}
