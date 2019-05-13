package com.github.daanielowsky.Oddaj_Ubrania.controllers;

import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import com.github.daanielowsky.Oddaj_Ubrania.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @ModelAttribute ("username")
    public String modelForUserFirstName() {
        User loggerUser = userService.getLoggerUser();
        if (loggerUser == null){
            return null;
        }
        return loggerUser.getFirstName();
    }

    @GetMapping("/landingpage")
    public String getLandingPageForLoggedUser() {
        return "landingpage";
    }

    @GetMapping("/profile")
    public String getProfilePageForUsers(Model model){
        User loggerUser = userService.getLoggerUser();
        model.addAttribute("user", loggerUser);
        return "profile";
    }
}
