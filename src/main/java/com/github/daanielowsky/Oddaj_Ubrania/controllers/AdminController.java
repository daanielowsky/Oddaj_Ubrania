package com.github.daanielowsky.Oddaj_Ubrania.controllers;


import com.github.daanielowsky.Oddaj_Ubrania.dto.OrganizationsDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import com.github.daanielowsky.Oddaj_Ubrania.services.OrganizationsService;
import com.github.daanielowsky.Oddaj_Ubrania.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private OrganizationsService organizationsService;
    private UserService userService;

    public AdminController(OrganizationsService organizationsService, UserService userService) {
        this.organizationsService = organizationsService;
        this.userService = userService;
    }

    @ModelAttribute ("username")
    public String modelForUserFirstName() {
        User loggerUser = userService.getLoggerUser();
        if (loggerUser == null){
            return null;
        }
        return loggerUser.getFirstName();
    }

    @GetMapping("/admin/administrationpanel")
    public String showAdminPanel(Model model){
        int numberOfOrganizations = organizationsService.getNumberOfOrganizations();
        model.addAttribute("number", numberOfOrganizations);
        return "adminpanel";
    }

    @GetMapping("/admin/add_organization")
    public String addingOrganizationForm(Model model){
        model.addAttribute("organization", new OrganizationsDTO());
        return "addorganization";
    }

    @PostMapping("/admin/add_organization")
    public String addingOrganization(@Valid @ModelAttribute("organization") OrganizationsDTO organizationsDTO, BindingResult result){
        if (result.hasErrors()) {
            return "addorganization";
        }
        organizationsService.registerOrganization(organizationsDTO);
        return "redirect:/admin/administrationpanel";
    }

    @GetMapping("/admin/show_users")
    public String showListOfUsers(Model model){
        List<User> listOfUsers = userService.getListOfUsers();

        model.addAttribute("list", listOfUsers);
        return "userslist";
    }
}
