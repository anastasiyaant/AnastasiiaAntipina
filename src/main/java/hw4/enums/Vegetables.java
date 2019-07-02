package hw4.enums;

public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    final String value;

    Vegetables(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
