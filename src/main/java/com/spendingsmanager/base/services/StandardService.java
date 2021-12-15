package com.spendingsmanager.base.services;

import com.spendingsmanager.base.exceptions.ValidationException;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class StandardService<T> {
    protected abstract JpaRepository<T, Long> getRepository();
    public abstract void save(String username, T entity);
    protected abstract void validateBeforeSave(T entity);
}
