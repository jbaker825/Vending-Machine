package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;

//This class will read the inventory data from a file, keep track of the current stock levels and prices of items, and update the stock levels when items are purchased.
public class Inventory {

    // Create a private Map called items
    private Map<String, Item> items;

    // CONSTRUCTOR
    // For Inventory that initializes items as a new LinkedHashMap
    public Inventory() {
        this.items = new LinkedHashMap<>();
        run();
    }

    // Method
    // Takes in two parameters: a String called slotId and an Item called item. This method adds the item to the map items, with the slotId as the key
    public void addItem(String slotId, Item item) {
        items.put(slotId, item);
    }

    // Method
    // Takes in one parameter: a String called slotId. This method removes the item with the given slotId from the map items
    public void removeItem(String slotId) {
        items.remove(slotId);
    }

    // Method
    // Takes in one parameter: a String called slotId. This method returns the item with the given slotId from the map items.
    public Item getItem(String slotId) {
        return items.get(slotId);
    }

    // Method
    // Returns the entire map items
    public Map<String, Item> getItems() {
        return items;
    }

// Create a run method that reads inventory data from a file called "catering.csv" and updates the itemsList
    public void run() {
        File inventoryFile = new File("catering.csv");
        // If the file exists, open a Scanner on the file
        if (inventoryFile.exists()) {
            try (Scanner vendingMachineItems = new Scanner(inventoryFile)) {
                // While there is still data in the file:
                // Read in a line from the file.
                while (vendingMachineItems.hasNextLine()) {
                    String fileLine = vendingMachineItems.nextLine();
                    String[] itemArr;
                    // Split the line into an array of Strings using the comma as the delimiter.
                    itemArr = fileLine.split(",");
                    // Create a new Item with the first element of the array as the slotId, the second element as the name, the third element as the price, and the fourth element as the type
                    // Add the item to the itemsList map with the slotId as the key
                    items.put(itemArr[0], new Item(itemArr[0], itemArr[1], Double.parseDouble(itemArr[2]), itemArr[3]));
                    // Close the Scanner
                }
                // Catch a FileNotFoundException and print "Error File Not Found"
            } catch (FileNotFoundException e) {
                System.out.println("Error File Not Found");
            }

        }
    }
}






