package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IOController {
    @GetMapping
    public String getIndex() {
        return "index.html";
    }

    @GetMapping("/converter")
    public String getConverter() {
        return "converter.html";
    }

}
