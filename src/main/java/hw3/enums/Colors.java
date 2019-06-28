package hw3.enums;

public enum Colors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String value;

    Colors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
