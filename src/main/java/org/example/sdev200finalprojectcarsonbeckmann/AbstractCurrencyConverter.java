package org.example.sdev200finalprojectcarsonbeckmann;

public abstract class AbstractCurrencyConverter {
    protected double amount;
    protected String fromCurrency;
    protected String toCurrency;

    // Common fields (counts toward 10+ fields)
    protected static final double USD_TO_EURO = 0.88;
    protected static final double USD_TO_PESO = 19.55;
    protected static final double USD_TO_YEN = 142.37;
    protected static final double USD_TO_RUPEE = 85.13;

    public abstract double convert() throws InvalidDataException;
}