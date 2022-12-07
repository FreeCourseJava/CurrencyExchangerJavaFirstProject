package com.example.controller;
//Controller for input and output to Web

import com.example.entity.Currency;
import com.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IOController {

  //  private final CurrencyService currencyService;

 //   @Autowired
   // public IOController(CurrencyService currencyService){
     //   this.currencyService = currencyService;
   // }
    @GetMapping
    public String getIndex(){
        return  "index.html";
    }

    @PostMapping
    @ResponseBody
    public List<Currency> requestController(){
        List<Currency> test = new ArrayList<>();
        test.add(new Currency("rub","rouble",1.0f,1));
        test.add(new Currency("eur","euro",51.2f,1));
        test.add(new Currency("usd","dollar",60.40f,1));
        return test;//currencyService.getAllCurrencies();
    }


}
