package hw3.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ServiceHeaderTitles {
    SUPPORT("support"),
    DATES("dates"),
    COMLEX_TABLE("complex table"),
    SIMPLE_TABLE("simple table"),
    TABLE_WITH_PAGES("table with pages"),
    DIFFERENT_ELEMENTS("different elements");

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

}
