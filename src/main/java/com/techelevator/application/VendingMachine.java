package com.techelevator.application;

import java.util.Map;

// VendingMachine is a class that manages a vending machine and its operations.
public class VendingMachine {
    private Inventory inventory;
    private double balance;

    // constructor creates a new Inventory object,
    public VendingMachine() {
        this.inventory = new Inventory();
        this.balance = 0.0;
    }

    // constructor takes an existing Inventory object
    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.balance = 0.0;
    }

    // keeps track of the amount of money that has been inserted into the machine.
    public double getBalance() {
        return balance;
    }

    // Method
    // Takes an integer argument balanceInCents which represents the new balance in cents that you want to set for the vending machine. The method then sets the instance variable balance to the new value.
    public void setBalance(int balanceInCents) {
        balance = balanceInCents;
    }

    // creates a string of the items available in the vending machine, including their slot ID, name, and price.
    public String displayItems() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Item> entry : inventory.getItems().entrySet()) {
            String slotId = entry.getKey();
            Item item = entry.getValue();
            sb.append(slotId).append(" ").append(item.getName()).append(" $").append(item.getPrice()).append("\n");
        }
        return sb.toString();
    }

    // takes a slot ID as an argument and checks if the item is in stock and if the balance is sufficient to purchase it. If the purchase is successful, the item is removed from the inventory and the method returns true. Otherwise, it returns false.
    public boolean purchaseItem(String slotId) {
        Item item = inventory.getItem(slotId);
        if (item == null) {
            return false;
        }
        if (balance < item.getPrice()) {
            return false;
        }
        balance -= item.getPrice();
        inventory.removeItem(slotId);
        return true;
    }

    // takes an integer amount as an argument, and adds that amount to the balance variable. If the amount is not valid, an IllegalArgumentException is thrown.
    public void feedMoney(int amount) {
        switch (amount) {
            case 1:
            case 2:
            case 5:
            case 10:
                balance += amount;
                break;
            default:
                throw new IllegalArgumentException("Invalid amount: " + amount);
        }
    }

    // calculates the change due to the user, in quarters, dimes, and nickels, and resets the balance to zero.
    public int[] returnChange() {
        int[] change = new int[3];
        int cents = (int) (balance * 100);
        change[0] = cents / 25;
        cents %= 25;
        change[1] = cents / 10;
        cents %= 10;
        change[2] = cents / 5;
        balance = 0.0;
        return change;
    }

    // returns a string indicating that an item is being dispensed.
    public String getDispensingMessage() {
        return "Dispensing...";
    }
}
