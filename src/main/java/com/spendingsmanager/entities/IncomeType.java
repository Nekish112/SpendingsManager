package com.spendingsmanager.entities;

public enum IncomeType {
    // TODO Fill in
    OTHER("Другое");

    private String label;

    IncomeType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
