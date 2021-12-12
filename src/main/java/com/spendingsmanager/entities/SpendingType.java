package com.spendingsmanager.entities;

public enum SpendingType {

    FOOD("Еда"),
    CAFE("Кафе"),
    HEALTH("Здоровье"),
    TRANSPORT("Транспорт"),
    HOUSING("Жилье"),
    ENTERTAINMENT("Равзлечения"),
    OTHER("Другое");

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
