package com.github.daanielowsky.Oddaj_Ubrania.controllers;

import com.github.daanielowsky.Oddaj_Ubrania.dto.RegistrationFormDTO;
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
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new RegistrationFormDTO());
        return "registerpage";
    }


    @PostMapping(value = "/register")
    public String registerUser(@Valid @ModelAttribute("user") RegistrationFormDTO form, BindingResult result) {
        if (result.hasErrors()) {
            return "registerpage";
        }

        if (!checkPasswordEquality(form)) {
            result.rejectValue("confirmedPassword", null, "Hasło i powtórzone hasło nie są takie same.");
            return "registerpage";
        }

        if (!checkIsEmailAvaiable(form)) {
            result.rejectValue("username", null, "Ten email jest już zajęty.");
            return "registerpage";
        }
        userService.registerUser(form);
        return "redirect:/";
    }

    private boolean checkIsEmailAvaiable(RegistrationFormDTO form) {
        User user = userService.findUserByEmail(form.getEmail());
        if (user == null){
            return true;
        }
        return false;
    }

    private boolean checkPasswordEquality(RegistrationFormDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());

    }

}
