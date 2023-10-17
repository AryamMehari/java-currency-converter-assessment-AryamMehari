package com.codingblackfemales;

import java.util.Scanner;

import com.codingblackfemales.BasicCurrencyConverter;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner objScanner = new Scanner(System.in);

        // Prompt the user to enter the amount they want to convert
        System.out.println("Enter the amount to convert: ");
        double enteredAmount = objScanner.nextDouble();

        // Prompt the user to enter the destination currency
        System.out.print("Enter the destination currency: ");
        objScanner.nextLine();
        String destinationCurrency = objScanner.nextLine();

        BasicCurrencyConverter newConversion = new BasicCurrencyConverter();

        //convert the users input into the destination currency
        double result = newConversion.convertCurrency("GBP",destinationCurrency, enteredAmount);

        System.out.println("The conversion is" + result);
        
        // Close the scanner
        objScanner.close();
    }
}
