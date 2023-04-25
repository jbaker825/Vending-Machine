package com.techelevator.application;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class will handle the logging of all purchases to an audit file.
// sets up a FileWriter to write to the Audit.txt file, and provides methods to log the different events that need to be audited, including money fed, items purchased, and change given.
public class Audit {
    private FileWriter fileWriter;

    public Audit() {
        try {
            fileWriter = new FileWriter("Audit.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Each event is timestamped and formatted appropriately, and the log is written to the file using the writeLog method.
    //  the log file is opened in append mode so that multiple runs of the program can append to the same file rather than overwriting it
    public void logMoneyFed(double amount, double totalMoney) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date date = new Date();

        String log = formatter.format(date) + " MONEY FED: " + String.format("$%.2f", amount) + " " + String.format("$%.2f", totalMoney) + "\n";

        writeLog(log);
    }

    public void logItemPurchased(String slotLocation, String itemName, double itemPrice, double moneyRemaining) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date date = new Date();

        String log = formatter.format(date) + " " + itemName + " " + slotLocation + " " + String.format("$%.2f", itemPrice) + " " + String.format("$%.2f", moneyRemaining) + "\n";

        writeLog(log);
    }

    public void logChangeGiven(double change, double moneyRemaining) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date date = new Date();

        String log = formatter.format(date) + " CHANGE GIVEN: " + String.format("$%.2f", change) + " " + String.format("$%.2f", moneyRemaining) + "\n";

        writeLog(log);
    }

    private void writeLog(String log) {
        try {
            fileWriter.write(log);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // the close method is called when the program is finished to ensure that any remaining data in the FileWriter is written to the file, then the file is closed
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


