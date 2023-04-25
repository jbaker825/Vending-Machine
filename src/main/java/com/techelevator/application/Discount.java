package com.techelevator.application;

import java.util.Date;

// Create a class called Discount
public class Discount {
    // numOfItemsPurchased, an integer representing the number of items purchased
    private int numOfItemsPurchased;
    private Date currentDate;

    // currentDate, a Date object representing the current date
    public Discount(Date currentDate) {
        this.currentDate = currentDate;
    }

    // Method
    // a method that checks if the discount can be applied based on the current number of items purchased. If the numOfItemsPurchased is even, the method resets numOfItemsPurchased to 0 and returns true, otherwise, it increments numOfItemsPurchased and returns false.
    public boolean isDiscountApplicable() {
        if (numOfItemsPurchased % 2 == 0) {
            numOfItemsPurchased = 0;
            return true;
        }
        numOfItemsPurchased++;
        return false;
    }

    // creates a new Discount object with the current date, creates two Item objects with their corresponding details, and sets the initial price for each item
    public static void main(String[] args) {
        Discount discount = new Discount(new Date());
        Item item1 = new Item("A1", "Chips", 1.50, "Snacks");
        Item item2 = new Item("A2", "Candy", 2.00, "Snacks");

        double price1 = item1.getPrice();
        double price2 = item2.getPrice();
    // If the discount is applicable, the price of the second item is decreased by $1.00
        if (discount.isDiscountApplicable()) {
            price2 -= 1.00;
        }
    // prints the name and price of each item
        System.out.println(item1.getItem() + " - Price: $" + String.format("%.2f", price1));
        System.out.println(item2.getItem() + " - Price: $" + String.format("%.2f", price2));
    }
}
