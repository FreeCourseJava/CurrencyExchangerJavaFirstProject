package com.example.service;

import com.example.entity.Currency;

import java.util.List;

public interface GetCurrencies {
    public Currency getCurrencies(String abrev);

    public List<Currency> getAllCurrencies();

}
