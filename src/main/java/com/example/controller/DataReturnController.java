package com.example.controller;

import com.example.entity.Currency;
import com.example.service.GetCurrencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DataReturnController {


    private final GetCurrencies getCurrencies;

    @Autowired
    public DataReturnController(GetCurrencies getCurrencies) {
        this.getCurrencies = getCurrencies;
    }

    @PostMapping
    public List<Currency> requestController() {
        return getCurrencies.getAllCurrencies();
    }

}
