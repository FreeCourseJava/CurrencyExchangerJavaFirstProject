package com.example.controller;

import com.example.entity.Currency;
import com.example.service.CurrencyService;
import com.example.service.GetCurrencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DataReturnController {


    //  private final GetCurrencies getCurrencies;

    //  @Autowired
    //public DataReturnController(GetCurrencies getCurrencies){
    //    this.getCurrencies = getCurrencies;
    //  }

    @PostMapping
    public List<Currency> requestController() {
        List<Currency> test = new ArrayList<>();
        test.add(new Currency("rub", "rouble", 1.0f, 1));
        test.add(new Currency("eur", "euro", 51.2f, 1));
        test.add(new Currency("usd", "dollar", 60.40f, 1));
        return test;
        //  return getCurrencies.getAllCurrencies();
    }

}
