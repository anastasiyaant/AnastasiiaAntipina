package hw3.enums;

public enum Conditions {
    TRUE("true"),
    FALSE("false");

    final String value;

    Conditions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
