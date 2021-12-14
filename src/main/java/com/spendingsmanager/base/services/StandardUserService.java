package com.spendingsmanager.base.services;

import com.spendingsmanager.base.entities.security.User;
import com.spendingsmanager.base.entities.security.roles.Role;
import com.spendingsmanager.base.repositories.security.StandardUserRepository;
import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.services.security.RegistrationService;

import java.util.Collections;

public abstract class StandardUserService<T extends User> extends StandardService<T> {
    public static class RegistrationException extends Exception {
        public RegistrationException(String msg) {
            super(msg);
        }
    }

    protected T findByUsername(String username) {
        validateBeforeSearch(username);
        T user = getRepository().findByUsername(username);
        return user;
    }

    public void save(T entity) {
        validateBeforeSave(entity);
        getRepository().save(entity);
    }

    @Override
    public void save(String username, T entity) {
        save(entity);
    }

    public void addUser(T user) throws RegistrationException {
        T userFromDb = findByUsername(user.getUsername());

        if (userFromDb != null) {
            throw new RegistrationException("User is already exists!");
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        save(user);
    }

    protected abstract void validateBeforeSearch(String entity);

    protected abstract StandardUserRepository<T> getRepository();
}
