package com.github.daanielowsky.Oddaj_Ubrania.controllers;

import com.github.daanielowsky.Oddaj_Ubrania.Repositories.UserRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.CollectionDTO;
import com.github.daanielowsky.Oddaj_Ubrania.dto.PasswordDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import com.github.daanielowsky.Oddaj_Ubrania.services.CollectionsService;
import com.github.daanielowsky.Oddaj_Ubrania.services.OrganizationsService;
import com.github.daanielowsky.Oddaj_Ubrania.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private OrganizationsService organizationsService;
    private CollectionsService collectionsService;

    public HomeController(UserService userService, PasswordEncoder passwordEncoder, UserRepository userRepository, OrganizationsService organizationsService, CollectionsService collectionsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.organizationsService = organizationsService;
        this.collectionsService = collectionsService;
    }

    @GetMapping("/")
    public String getMainPage(Model model){
        User loggerUser = userService.getLoggerUser();
        if (loggerUser != null){
            return "redirect:/landingpage";
        }
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
    public String getLandingPageForLoggedUser(Model model) {
        model.addAttribute("organizations", organizationsService.getAllOrganizations());
        model.addAttribute("collection", new CollectionDTO());
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
        if(passwordEncoder.encode(loggerUser.getPassword()).equals(password.getOldPassword())){
            result.rejectValue("oldPassword", null, "Podane hasło nie jest prawidłowe.");
            return "passwordchange";
        }

        if(!password.getPassword().equals(password.getConfirmedPassword())){
            result.rejectValue("confirmedPassword", null, "Hasło i powtórzone hasło nie są takie same.");
            return "passwordchange";
        }

        loggerUser.setPassword(passwordEncoder.encode(password.getPassword()));
        userRepository.save(loggerUser);
        return "redirect:/profile";
    }

    @GetMapping("/user/create_collection")
    public String createCollectionForm(Model model){
        List<Organizations> allOrganizations = organizationsService.getAllOrganizations();
        model.addAttribute("collection", new CollectionDTO());
        model.addAttribute("organizations", allOrganizations);
        return "createcollection";
    }

    @PostMapping("/user/create_collection")
    public String metodka(@ModelAttribute @Valid CollectionDTO collectionDTO, BindingResult result){
        if (result.hasErrors()) {
            return "createcollection";
        }
        collectionsService.saveCollection(collectionDTO);
        return "redirect:/landingpage";
    }
}
