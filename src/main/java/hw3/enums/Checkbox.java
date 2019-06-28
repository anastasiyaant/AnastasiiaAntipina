package hw3.enums;

public enum Checkbox {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    WIND("Wind");

    final String value;

    Checkbox(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
