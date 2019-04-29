package com.github.daanielowsky.Oddaj_Ubrania.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }
}
