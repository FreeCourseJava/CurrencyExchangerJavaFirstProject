package com.example.entity;

public class Currency {
    private String currencyAbbreviation;
    private String name;
    private float currencyRate;

    private int currencyDenomination;

    public Currency(String currencyAbbreviation, String name, float currencyRate, int currencyDenomination) {
        this.currencyAbbreviation = currencyAbbreviation;
        this.name = name;
        this.currencyRate = currencyRate;
        this.currencyDenomination = currencyDenomination;
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

    public float getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(float currencyRate) {
        this.currencyRate = currencyRate;
    }

    public int getCurrencyDenomination() {
        return currencyDenomination;
    }

    public void setCurrencyDenomination(int currencyDenomination) {
        this.currencyDenomination = currencyDenomination;
    }
}
