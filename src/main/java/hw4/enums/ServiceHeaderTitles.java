package hw4.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ServiceHeaderTitles {
    SUPPORT("Support"),
    DATES("Dates"),
    SEARCH("Search"),
    COMLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    final String name;

    ServiceHeaderTitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getServiceHeaderTitlesStringList() {
        return Stream.of(ServiceHeaderTitles.values()).map(v -> v.getName()).collect(Collectors.toList());
    }

    public static List<String> getServiceHeaderTitlesStringListUpperCase() {
        return Stream.of(ServiceHeaderTitles.values()).map(v -> v.getName().toUpperCase()).collect(Collectors.toList());
    }

}
