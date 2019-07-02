package hw4.enums;

public enum Elements {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    WIND("Wind");

    final String value;

    Elements(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
