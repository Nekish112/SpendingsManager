package com.spendingsmanager.entities;

public enum PaymentType {
    CARD("Card"),
    CASH("Наличные"),
    OTHER("Другое");

    private String label;

    PaymentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
