package com.github.daanielowsky.Oddaj_Ubrania.controllers;

import com.github.daanielowsky.Oddaj_Ubrania.dto.PasswordDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import com.github.daanielowsky.Oddaj_Ubrania.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/profile/settings")
    public String getFormForUserProfileEdit(Model model){
        User loggerUser = userService.getLoggerUser();
        model.addAttribute("user", loggerUser);
        return "profileedit";
    }

    @PostMapping("/profile/settings")
    public String updateUsersProfile(@Valid @ModelAttribute User user, BindingResult result){
        if (result.hasErrors()){
            return "profileedit";
        }
        userService.editUser(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile/password")
    public String changingPasswordForm(Model model){
        model.addAttribute("password", new PasswordDTO());
        return "passwordchange";
    }

    @PostMapping("/profile/password")
    public String changingUsersPassword(@Valid @ModelAttribute("password") PasswordDTO password, BindingResult result){
        if (result.hasErrors()){
            return "passwordchange";
        }
        User loggerUser = userService.getLoggerUser();
        if(loggerUser.getPassword() != password.getOldPassword()){
            result.rejectValue("oldPassword", null, "Podane hasło nie jest prawidłowe.");
            return "passwordchange";
        }
        if(password.getPassword() != password.getConfirmedPassword()){
            result.rejectValue("confirmedPassword", null, "Hasło i powtórzone hasło nie są takie same.");
            return "passwordchange";
        }
        loggerUser.setPassword(password.getPassword());
        return "redirect:/profile";
    }
}
