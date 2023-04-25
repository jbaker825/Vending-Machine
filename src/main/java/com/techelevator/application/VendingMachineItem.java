package com.techelevator.application;

public class VendingMachineItem {
    private String slotId;
    private String name;
    private int priceInCents;
    private int quantity;

    // CONSTRUCTOR
    public VendingMachineItem(String slotId, String name, int priceInCents) {
        // Set slotId to slotId
        this.slotId = slotId;
        // Set name to name
        this.name = name;
        // Set priceInCents to priceInCents
        this.priceInCents = priceInCents;
        // Set quantity to 5
        this.quantity = 5;
    }

    // Method
    public String getSlotId() {
        return slotId;
    }

    // Method
    public String getName() {
        return name;
    }

    // Method
    public int getPriceInCents() {
        return priceInCents;
    }

    // Method
    public int getQuantity() {
        return quantity;
    }

    // Method
    // Decrement quantity by 1
    public void decrementQuantity() {
        quantity--;
    }
}
