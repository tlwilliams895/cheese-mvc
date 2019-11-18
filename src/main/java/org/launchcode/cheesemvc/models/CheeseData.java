//package org.launchcode.cheesemvc.models;
//
//import java.util.ArrayList;
//
//// Refactor CheeseController to move the data management code into the CheeseData model class.
//// Create the utility methods getAll, add, remove, and getById here from the CheeseController.
//public class CheeseData {
//    static ArrayList<Cheese> cheeses = new ArrayList<>();
//
//    // getAll - Retrieves all the cheeses
//    public static ArrayList<Cheese> getAll() {
//        return cheeses;
//    }
//
//    // add - Add cheese to the list; nothing will be returned
//    public static void add(Cheese newCheese) {
//        cheeses.add(newCheese);
//    }
//
//    // remove - Remove cheese from the list by Id
//    public static void remove(int id) {
//        Cheese cheeseToRemove = getById(id);
//        cheeses.remove(cheeseToRemove);
//    }
//
//    // getById - Retrieves the cheese by Id
//    public static Cheese getById(int id) {
//        Cheese theCheese = null;
//
//        // The for loop will find the cheese with given Id
//        for (Cheese candidateCheese : cheeses) {
//            if (candidateCheese.getCheeseId() == id) {
//                theCheese = candidateCheese;
//            }
//        }
//        return theCheese;
//    }
//}
