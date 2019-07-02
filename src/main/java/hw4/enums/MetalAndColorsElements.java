package hw4.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MetalAndColorsElements {
    SUMMARY("Summary: "),
    ELEMENTS("Elements: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLES("Vegetables: ");

    final String name;

    MetalAndColorsElements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getMenuStringList() {
        return Stream.of(Menu.values()).map(v -> v.getName()).collect(Collectors.toList());
    }
}
