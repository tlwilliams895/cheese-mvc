package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
public class Cheese {
    // variables/attributes/fields
    // Set Java Validation for name and description fields
    // @Id and @ GeneratedValue declares the primary key column
    // as unique and the values will be generated
    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 5, message = "Description must NOT be empty!")
    private String description;

    // Allows user to select type of cheese from drop-down
    private CheeseType type;

    private int cheeseId;
    private static int nextId = 1;

     //Constructor method signatures
     public Cheese(String name, String description) {
         this();
         this.name = name;
         this.description = description;
     }

    // no-arg constructor to set unique Ids for the objects
    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    // Getters and Setters

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
