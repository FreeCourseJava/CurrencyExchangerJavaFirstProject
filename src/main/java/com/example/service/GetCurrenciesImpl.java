package com.example.service;

import com.example.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCurrenciesImpl implements GetCurrencies {

    private final CurrencyFromRepository currencyFromRepository;

    @Autowired
    public GetCurrenciesImpl(CurrencyFromRepository currencyFromRepository) {
        this.currencyFromRepository = currencyFromRepository;
    }

    @Override
    public Currency getCurrencies(String abrev) {
        List<Currency> listCurrencies = getAllCurrencies();
        for (Currency currCurrency : listCurrencies) {
            if (currCurrency.getCurrencyAbbreviation().equals(abrev)) {
                return currCurrency;
            }
        }
        return null;
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyFromRepository.getCurrencyRates();
    }
}
