package de.roeer.epost.tests.tests.currencychange;

public class Change {
    private final int _dollars;
    private final int _quarters; //25 cents
    private final int _dimes; // 10 cents
    private final int _nickels; // 5 cents
    private final int _cents; // 1 cent


    public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
        _dollars = dollars;
        _quarters = quarters;
        _dimes = dimes;
        _nickels = nickels;
        _cents = cents;
    }


    public int getDollars() {
        return _dollars;
    }


    public int getQuarters() {
        return _quarters;
    }


    public int getDimes() {
        return _dimes;
    }


    public int getNickels() {
        return _nickels;
    }


    public int getCents() {
        return _cents;
    }
    
}
