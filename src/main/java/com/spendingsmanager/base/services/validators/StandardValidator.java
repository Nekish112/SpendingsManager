package com.spendingsmanager.base.services.validators;

import com.spendingsmanager.base.exceptions.ValidationException;

public interface StandardValidator<T> {
    void validate(T object);
}
