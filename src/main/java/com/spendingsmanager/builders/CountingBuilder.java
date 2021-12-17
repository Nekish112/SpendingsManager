package com.spendingsmanager.builders;

import com.spendingsmanager.base.builders.StandardBuilder;
import com.spendingsmanager.entities.Counting;
import org.springframework.stereotype.Service;

@Service
public class CountingBuilder implements StandardBuilder<Counting> {
    @Override
    public Counting build() {
        return new Counting();
    }
}
