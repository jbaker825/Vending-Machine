package com.techelevator.application;

import java.util.Scanner;
import java.util.Date;

// This class will handle the purchase process flow, including feeding money, selecting items, and dispensing items.
public class Purchase {
    private Discount discount = new Discount(new Date());
    private Selection selection = new Selection();
    private double customerMoney;
    private double machineMoney;
    private Item item;
    private double itemPrice;
    private Scanner scanner = new Scanner(System.in); // Add this line to define a Scanner object

    //Declare a method named purchaseItem that doesn't return anything.
    public void purchaseItem() {
        //If the item selected by the customer is available:
        if (selection.isAvailable()) {
            //Retrieve the item from the selection.
            item = selection.getItem();
            //Get the price of the item.
            itemPrice = item.getPrice();
//            //If a discount is applicable:
            if (discount.isDiscountApplicable()) {
                //Ask the customer to enter a discount code for the second item.
                System.out.print("Enter discount code for second item: ");
                String discountCode = scanner.nextLine();
                //If the discount code is "SPRINGBOGO":
                if (discountCode.equals("SPRINGBOGO")) {
                    //Reduce the item price by $1.00.
                    itemPrice -= 1.00;
                }
            }
            System.out.println(item.getName() + ", " + item.getSound());
            System.out.println("Price: $" + String.format("%.2f", itemPrice));
            //Deduct the item price from the customer's money and round the result to two decimal places.
            customerMoney = Math.round((customerMoney - itemPrice) * 100.0) / 100.0;
            //Add the item price to the machine's money and round the result to two decimal places.
            machineMoney = Math.round((machineMoney + itemPrice) * 100.0) / 100.0;
            //Play the sound of the item.
            System.out.println(item.getSound());
            //End the if block for the item availability.
            //If the item selected by the customer is not available, print a message indicating so.
        } else {
            //
            System.out.println("Item is not available.");
        }
    }

    // Other methods and variables go here
}

class Selection {
    public boolean isAvailable() {
        // implementation
        return true;
    }

    public Item getItem() {
        // implementation
        return new Item();
    }
}



