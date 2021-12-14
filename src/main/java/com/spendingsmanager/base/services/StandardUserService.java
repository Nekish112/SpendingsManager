package com.spendingsmanager.base.services;

import com.spendingsmanager.base.entities.security.User;

public abstract class StandardUserService<T extends User> extends StandardService<T> {
    protected abstract T findByUsername(String username);
}
