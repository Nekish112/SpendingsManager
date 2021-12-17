package com.spendingsmanager.base.builders;

import com.spendingsmanager.base.entities.StandardEntity;

public interface StandardBuilder<T extends StandardEntity> {
    T build();
}
