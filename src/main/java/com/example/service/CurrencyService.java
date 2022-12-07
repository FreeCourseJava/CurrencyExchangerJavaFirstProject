package com.example.service;

import java.util.List;

import com.example.entity.Currency;

public interface CurrencyService {
    Currency getCurrencies(long id);

    List<Currency> getAllCurrencies();
}
