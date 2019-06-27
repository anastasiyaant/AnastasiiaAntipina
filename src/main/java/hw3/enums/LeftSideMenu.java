package hw3.enums;

public enum LeftSideMenu {
    HOME("Home"),
    CONTACT_FORM("Contact Form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements packs");

    final String name;

    LeftSideMenu(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
