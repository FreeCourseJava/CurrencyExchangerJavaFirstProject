package com.example;

public class Currency {
    private String currencyAbbreviation;
    private String name;
    private long currencyRate;

    public Currency(String currencyAbbreviation, String name, long currencyRate) {
        this.currencyAbbreviation = currencyAbbreviation;
        this.name = name;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(long currencyRate) {
        this.currencyRate = currencyRate;
    }
}
