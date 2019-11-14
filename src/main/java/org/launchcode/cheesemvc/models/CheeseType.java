package org.launchcode.cheesemvc.models;

// Allows users to select type of cheese from the Cheese class
// Java convention must be in all CAPS within the fields/variables below
public enum CheeseType {
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    // Display list of cheese types and the constructor will initialize
    // the variable/field called name
    private final String name;

    // constructor to initialize the original variable
    CheeseType(String name) {
        this.name = name;
    }

    // Getter - To obtain the value
    public String getName() {
        return name;
    }
}
