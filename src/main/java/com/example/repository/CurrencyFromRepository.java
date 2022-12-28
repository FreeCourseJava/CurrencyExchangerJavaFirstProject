package com.example.repository;

import com.example.entity.Currency;

import java.util.List;

public interface CurrencyFromRepository {
    void dailyUpdateBD(String date);

    List<Currency> getCurrencyRates();

    Currency getRateByCurrencyAndDate(String currencyAbbrev, String date);
}
