package com.example.service;

import com.example.entity.Currency;

import java.util.List;


public interface GetCurrencies {
    Currency getCurrencies(String abrev);

    List<Currency> getAllCurrencies();

}
