package de.roeer.epost.tests.tests.currencychange;

public class CurrencyChange {

	/*  
    Take cents as a parameter
    and return an equal amount in dollars and coins using the minimum number of
    coins possible.
    For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
    Return null if the parameter is negative.
   */
	
	
	    public static Change getCorrectChange(int cents) {
	      
	    	if(cents < 0){
	    		return null;
	    	}
	    	
	    	int dollars = 0;
	    	int quarters = 0;
	    	int dimes = 0;
	    	int nickels = 0;
	    	
	    
	    	
            dollars = findNumberOfCoinsInAmount(cents, 100);
	        cents = cents - dollars * 100;
            
	    	quarters = findNumberOfCoinsInAmount(cents, 25);
	    	cents = cents - quarters*25;
	    	
            dimes = findNumberOfCoinsInAmount(cents, 10);
	    	cents = cents- dimes*10;

	    	nickels = findNumberOfCoinsInAmount(cents, 5);
	    	cents = cents - nickels*5;
	    	
	    	Change change = new Change(dollars, quarters, dimes, nickels, cents);
	    	return change;

	    }


private static int findNumberOfCoinsInAmount(int amount, int valueOfCoin){
	
	int numberOfCoins = 0;
	
	while(amount >= valueOfCoin){
		numberOfCoins++;
		amount = amount - valueOfCoin;
	}
	
	return numberOfCoins;
}
	



	
	
}
