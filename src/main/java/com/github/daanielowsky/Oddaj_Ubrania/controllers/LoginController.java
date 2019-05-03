package com.github.daanielowsky.Oddaj_Ubrania.controllers;

import com.github.daanielowsky.Oddaj_Ubrania.Repositories.UserRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.LoginFormDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoggingForm(Model model){
        model.addAttribute("loginform", new LoginFormDTO());
        return "loginpage";
    }


    @PostMapping("/login")
    public String loginValidation(@Valid @ModelAttribute User user, BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "loginpage";
        }
        User existingUser = userRepository.findFirstByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            result.addError(new FieldError("user", "email", "Email lub hasło nieprawidłowe"));
            return "loginpage";
        }
        session.setAttribute("userID", existingUser.getId());
        return "redirect:/";
    }
}
