package com.example.service;

import java.util.List;

import com.example.entity.Currency;

public interface GetCurrencies {
    Currency getCurrencies(String abrev);

    List<Currency> getAllCurrencies();

}
