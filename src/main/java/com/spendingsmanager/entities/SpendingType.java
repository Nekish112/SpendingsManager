package com.spendingsmanager.entities;

public enum SpendingType {

    FOOD("Food"),
    CAFE("Cafe"),
    HEALTH("Health"),
    TRANSPORT("Transport"),
    HOUSING("Housing"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other");

    private String label;

    SpendingType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
