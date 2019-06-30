package hw3.enums;

public enum Radio {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String value;

    Radio(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
