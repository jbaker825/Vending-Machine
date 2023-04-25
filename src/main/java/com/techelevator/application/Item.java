package com.techelevator.application;

// This class will represent a single item in the vending machine, with attributes for the name, price, quantity, and type.
public class Item {
    public Item() {
        // default constructor
    }

    public String getSound() {
        // implementation
        return "sound";
    }

    private String slotIdentifier;
    private String name;
    private Double price;
    private String category;

    public Item(String slotIdentifier, String name, Double price, String category){
        this.slotIdentifier = slotIdentifier;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getSlotIdentifier(){
        return slotIdentifier;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public String getCategory(){
        return category;
    }

    public String getItem(){
        return String.format("%s) %s: $%s", slotIdentifier, name, price);
    }
}
