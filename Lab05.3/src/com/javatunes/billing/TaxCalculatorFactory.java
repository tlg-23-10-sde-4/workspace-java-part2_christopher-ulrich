/*
 * Some header text
 */

package com.javatunes.billing;

public class TaxCalculatorFactory{
    // prevent instantiation from outside, this is an all-static class
    private TaxCalculatorFactory() {
    }

    /*
     * TODO: Consider implementing a "cache" of TaxCalculator objects.
     *
     * If I have not previously created the object - USATax, maybe -
     * then I'll create it here, add it to my cache, and then return it
     *
     * If my cache already contains it, then I just fetch it and return it.
     *
     * Hint: use a Map<Location,TaxCalculator> for the cache.
     * Hint: mirror DuckRace
     */

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;
        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }
}