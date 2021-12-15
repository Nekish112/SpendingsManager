package com.spendingsmanager.base.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {
    private Map<String, String> errors;

    public ValidationException(String exc) {
        super(exc);
    }

    public ValidationException(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return new HashMap(errors);
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry error : errors.entrySet()) {
            builder.append(error.getValue());
            builder.append("\n");
        }

        return builder.toString();
    }
}
