package hw4.enums;

public enum Metals {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String value;

    Metals(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
