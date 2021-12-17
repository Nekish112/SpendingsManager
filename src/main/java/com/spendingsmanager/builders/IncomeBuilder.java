package com.spendingsmanager.builders;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.entities.Income;
import org.springframework.stereotype.Service;

@Service
public class IncomeBuilder implements StandardBuilder<Income> {
    @Override
    public Income build() {
        return new Income();
    }
}
