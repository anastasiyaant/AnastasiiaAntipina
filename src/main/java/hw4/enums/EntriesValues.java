package hw4.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EntriesValues {
    FIVE("5"),
    TEN("10"),
    FIFTENEN("15"),
    TWENTY("20");

    final String value;

    EntriesValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
