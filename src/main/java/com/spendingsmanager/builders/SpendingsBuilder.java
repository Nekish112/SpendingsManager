package com.spendingsmanager.builders;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.entities.Spending;
import org.springframework.stereotype.Component;

@Component
public class SpendingsBuilder implements StandardBuilder<Spending> {
    @Override
    public Spending build() {
        return new Spending();
    }
}
