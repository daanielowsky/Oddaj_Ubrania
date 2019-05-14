package com.github.daanielowsky.Oddaj_Ubrania.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/administrationpanel")
    public String showAdminPanel(){
        return "adminpanel";
    }
}
