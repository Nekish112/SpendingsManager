package com.spendingsmanager.base.services;

import com.spendingsmanager.base.entities.security.StandardEntity;
import com.spendingsmanager.base.entities.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class StandardDomainService<T extends StandardEntity> extends StandardService<T> {

    @Autowired
    protected StandardUserService standardUserService;

    public abstract T findByUser(String username);

    @Override
    public void save(String username, T entity) {
        User user = getStandardUserService().findByUsername(username);

        entity.setUser(user);

        validateBeforeSave(entity);

        getRepository().save(entity);
    }

    protected abstract void validateBeforeSave(T entity);

    protected StandardUserService getStandardUserService() {
        return standardUserService;
    }

    protected abstract JpaRepository<T, Long> getRepository();
}
