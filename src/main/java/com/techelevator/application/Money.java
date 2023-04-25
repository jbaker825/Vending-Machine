package com.techelevator.application;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Initialize Money class with a starting balance of 0
public class Money {
    private double balance;

    public Money() {
        this.balance = 0;
    }

    // Define method to add money to the balance feedMoney(amount):
    public void feedMoney(double amount) {
        if (amount == 1 || amount == 5 || amount == 10 || amount == 20) {
            this.balance += amount;
            logTransaction("MONEY FED:          $" + String.format("%.2f", amount) +
                    "   $" + String.format("%.2f", this.balance));
        }
    }

    // Define method to get the current balance
    public double getBalance() {
        return this.balance;
    }

    // Define method to subtract money from the balance
    public void subtractMoney(double amount) {
        this.balance -= amount;
    }

    // Define method to get change and update the balance accordingly
    public String getChange() {
        double remainingBalance = this.balance;
        int quarters = (int) (remainingBalance / 0.25);
        remainingBalance = remainingBalance - (quarters * 0.25);
        int dimes = (int) (remainingBalance / 0.1);
        remainingBalance = remainingBalance - (dimes * 0.1);
        int nickels = (int) (remainingBalance / 0.05);
        remainingBalance = remainingBalance - (nickels * 0.05);
        logTransaction("CHANGE GIVEN:       $" + String.format("%.2f", (quarters * 0.25) + (dimes * 0.1) + (nickels * 0.05)) +
                "   $" + String.format("%.2f", remainingBalance));
        this.balance = 0;
        return "Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels: " + nickels;
    }

    // Define a private method to log transactions
    private void logTransaction(String message) {
        try {
            FileWriter writer = new FileWriter("Audit.txt", true);
            writer.write(getCurrentTime() + " " + message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Define a private method to get the current time
    private String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
