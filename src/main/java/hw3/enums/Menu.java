package hw3.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getMenuStringList() {
        return Stream.of(Menu.values()).map(v -> v.getName()).collect(Collectors.toList());
    }
}
