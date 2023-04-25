package com.techelevator;

import java.util.Scanner;
import com.techelevator.application.VendingMachine;
import com.techelevator.application.Inventory;

public class VendingMachineCLI {

    // Create a new instance of VendingMachine
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(new Inventory());
        // Loop while true:
        while (true) {
            // Display main menu
            System.out.println("===================================");
            System.out.println("Welcome to the Vendo-Matic 800!");
            System.out.println("===================================");
            System.out.println("(D)Display Vending Machine Items");
            System.out.println("(P)Purchase");
            System.out.println("(Q)Quit");

            // Read user input
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();

            // Process / switch on user input
            switch (choice) {
                // If "D" is selected:
                // Display the list of items in the vending machine using the displayItems method of the VendingMachine class
                case "D":
                    System.out.println(vendingMachine.displayItems());
                    break;
                // If "P" is selected:
                case "P":
                    // Loop while true
                    while (true) {
                        // Display the purchase menu and the current balance of the vending machine
                        System.out.println("===================================");
                        System.out.println("Purchase Menu");
                        System.out.println("===================================");
                        System.out.printf("Current Money Provided: $%.2f\n", vendingMachine.getBalance());
                        System.out.println("(M)Feed Money");
                        System.out.println("(S)Select Product");
                        System.out.println("(F)Finish Transaction");

                        // Read user input
                        String purchaseChoice = scanner.nextLine().toUpperCase();

                        // Process / switch on user input
                        switch (purchaseChoice) {
                            // If "M" is selected:
                            case "M":
                                // Prompt the user to enter an amount to add to the vending machine balance
                                System.out.println("How much would you like to add? ($1, $2, $5, $10)");
                                // Add the amount to the balance using the feedMoney method of the VendingMachine class
                                String moneyToAddString = scanner.nextLine();
                                int moneyToAdd = Integer.parseInt(moneyToAddString);
                                vendingMachine.feedMoney(moneyToAdd);
                                break;
                            // If "S" is selected:
                            case "S":
                                // Display the list of items in the vending machine using the displayItems method of the VendingMachine class
                                System.out.println(vendingMachine.displayItems());
                                // Prompt the user to enter a slot identifier
                                System.out.println("Please enter a slot identifier:");
                                String slotId = scanner.nextLine().toUpperCase();
                                // Attempt to purchase the item using the purchaseItem method of the VendingMachine class and the entered slot identifier
                                boolean isSuccessfulPurchase = vendingMachine.purchaseItem(slotId);
                                // If the purchase is successful, display a dispensing message using the getDispensingMessage method of the VendingMachine class
                                if (isSuccessfulPurchase) {
                                    System.out.println(vendingMachine.getDispensingMessage());
                                } else {
                                    // If the purchase is unsuccessful, display a failure message
                                    System.out.println("Purchase failed. Please try again.");
                                }
                                break;
                            // If "F" is selected:
                            case "F":
                                // Return the change to the user using the returnChange method of the VendingMachine class
                                int[] change = vendingMachine.returnChange();
                                System.out.printf("Returning change: $%.2f\n", vendingMachine.getBalance() / 100.0);
                                System.out.printf("Quarters: %d\n", change[0]);
                                System.out.printf("Dimes: %d\n", change[1]);
                                System.out.printf("Nickels: %d\n", change[2]);
                                vendingMachine.setBalance(0); // add this line to reset the balance to zero
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                        // Check if user wants to return to main menu
                        if (purchaseChoice.equals("F")) {
                            break;
                        }
                    }
                    break;
                case "F":
                    // Exit the program
                    System.exit(0);
                    // If none of the above options are selected:
                default:
                    // Display an error message.
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
