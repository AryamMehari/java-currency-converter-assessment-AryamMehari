package com.codingblackfemales;

import java.util.HashMap;

public class BasicCurrencyConverter implements CurrencyConverter {

    HashMap<String, Double> exchangeRates; 

    // This constructor method calls the Currencies class
    public BasicCurrencyConverter(Currencies currencies){
        
        // Assigning the value of all exchange rates to the exchangeRates variable by calling the getAllExchangeRates method from the currenciesGBPclass.
        exchangeRates = currencies.getAllExchangeRates();
    }

    //This method will convert the HashMap of currency codes into an array.
    public String[] getCurrencyCodes(){

        //Creating an empty array 
        String [] currencyCodeArrays = new String [exchangeRates.size()];

        int i = 0; 
        //looping through the keyset of the hashmap
        for (String currencyCodeArray : exchangeRates.keySet()) {
            currencyCodeArrays[i] = currencyCodeArray;
            i++;
        }

        return currencyCodeArrays;
    }


    //This method will return the exchange rate between the provided currencies and handle any exceptions. 

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode){

        if (sourceCurrencyCode == null || sourceCurrencyCode.isEmpty() ){
            return 0d;
        } 

        if (destinationCurrencyCode == null || destinationCurrencyCode.isEmpty()){
            return 0d;
        }

        if ( !exchangeRates.containsKey(destinationCurrencyCode) || !exchangeRates.containsKey(sourceCurrencyCode)){
            return 0d;
        }

        return ((exchangeRates.get(destinationCurrencyCode)/(exchangeRates.get(sourceCurrencyCode))));
    
    }

    // This method will convert currency from original currency to final currency.

    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount){

        if (amount <= 0){
            return 0d;
        } 

        return amount * getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
        
    }
  
    
}
