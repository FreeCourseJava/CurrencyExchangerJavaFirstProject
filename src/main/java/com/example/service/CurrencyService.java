package com.example.service;

import com.example.entity.Currency;

import java.util.List;

public interface CurrencyService {
    public Currency getCurrencies(long id);

    public List<Currency> getAllCurrencies();
}
