package com.example.entity;

public final class CurrencyMapper {

    private CurrencyMapper() {
    }


    public static CurrencyDAO getCurrencyDAO(Currency currency) {
        CurrencyDAO currencyDAO = new CurrencyDAO();
        currencyDAO.setName(currency.getName());
        currencyDAO.setCurrencyDenomination(currency.getCurrencyDenomination());
        currencyDAO.setCurrencyAbbreviation(currency.getCurrencyAbbreviation());
        return currencyDAO;
    }

    public static Currency getCurrency(CurrencyDAO currencyDAO, RateDAO rateDAO) {
        return new Currency(currencyDAO.getCurrencyAbbreviation(), currencyDAO.getName(),
                rateDAO.getRate(), currencyDAO.getCurrencyDenomination());
    }

}
