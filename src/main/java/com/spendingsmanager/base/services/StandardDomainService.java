package com.spendingsmanager.base.services;

import com.spendingsmanager.base.entities.StandardEntity;
import com.spendingsmanager.base.entities.security.User;
import com.spendingsmanager.base.repositories.StandardDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class StandardDomainService<T extends StandardEntity> extends StandardService<T> {

    public List<T> findAllByUser(User user) {
        List<T> entities = null;

        if (user != null) {
            entities = getRepository().findByUser(user);
        }

        return entities;
    }

    public List<T> findAllByUsername(String username) {
        User user = getStandardUserService().findByUsername(username);
        return findAllByUser(user);
    }

    @Override
    public void save(String username, T entity) {
        User user = getStandardUserService().findByUsername(username);

        entity.setUser(user);

        validateBeforeSave(entity);

        getRepository().save(entity);
    }

    protected abstract StandardUserService getStandardUserService();

    protected abstract StandardDomainRepository<T> getRepository();
}
