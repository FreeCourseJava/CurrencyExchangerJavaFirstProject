package com.example.service;

import com.example.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetCurrenciesImpl implements GetCurrencies {
    
    private final CurrencyList currencyList;

    @Autowired
    public GetCurrenciesImpl(CurrencyList currencyList){
        this.currencyList = currencyList;
    }
    @Override
    public Currency getCurrencies (String abrev) {
        List<Currency> listCurrencies = getAllCurrencies();
        for (Currency currCurrency : listCurrencies){
                if (currCurrency.getCurrencyAbbreviation().equals(abrev)){
                    return currCurrency;
                }
        }
        return null;
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyList.getCurrencyRates();
    }
}
