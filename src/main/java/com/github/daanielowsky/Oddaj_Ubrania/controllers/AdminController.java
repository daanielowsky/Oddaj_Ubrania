package com.github.daanielowsky.Oddaj_Ubrania.controllers;


import com.github.daanielowsky.Oddaj_Ubrania.dto.OrganizationsDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Role;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import com.github.daanielowsky.Oddaj_Ubrania.services.OrganizationsService;
import com.github.daanielowsky.Oddaj_Ubrania.services.RoleService;
import com.github.daanielowsky.Oddaj_Ubrania.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private OrganizationsService organizationsService;
    private UserService userService;
    private RoleService roleService;

    public AdminController(OrganizationsService organizationsService, UserService userService, RoleService roleService) {
        this.organizationsService = organizationsService;
        this.userService = userService;
        this.roleService = roleService;
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
        int amountOfUsers = userService.getAmountOfUsers();
        int amountOfAdmins = userService.getAmountOfAdmins();
        model.addAttribute("number", numberOfOrganizations);
        model.addAttribute("usersamount", amountOfUsers);
        model.addAttribute("adminsamount",amountOfAdmins);
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

    @GetMapping("/admin/edituser/{userid}")
    public String editForm(@PathVariable("userid") Long id, Model model){
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return "profileeditbyadmin";

    }

    @PostMapping("/admin/edituser/{userid}")
    public String editUserByAdmin(@PathVariable("userid") Long id, @Valid @ModelAttribute User user, BindingResult result) {
        if(result.hasErrors()) {
            return "profileeditbyadmin";
        }
        userService.editUserAsAdmin(user, id);
        return "redirect:/admin/administrationpanel";
    }

    @GetMapping("/admin/deleteuser/{userid}")
    public String deleteUserByAdmin(@PathVariable("userid") Long id){
        userService.deleteUserAsAdmin(id);
        return "redirect:/admin/administrationpanel";
    }

    @GetMapping("/admin/show_admins")
    public String showAdminsList(Model model){
        List<User> allAdmins = userService.getAllAdmins();
        model.addAttribute("list", allAdmins);
        return "adminslist";
    }

    @GetMapping("/admin/show_organizations")
    public String showOrganizationsList(Model model){
        model.addAttribute("organizations", organizationsService.getAllOrganizations());
        return "organizationslist";
    }

    @GetMapping("/admin/editorganization/{orgid}")
    public String editOrganizationForm(@PathVariable("orgid") Long id, Model model){
        Organizations organization = organizationsService.getOrganization(id);
        model.addAttribute("organization", organization);
        return "editorganization";
    }

    @PostMapping("/admin/editorganization/{orgid}")
    public String editOrganization(@PathVariable("orgid") Long id, @ModelAttribute @Valid Organizations organizations, BindingResult result){
        organizationsService.editOrganization(organizations, id);
        return "redirect:/admin/administrationpanel";
    }

    @GetMapping("/admin/deleteorganization/{orgid}")
    public String deleteOrganization(@PathVariable("orgid") Long id){
        organizationsService.deleteOrganization(id);
        return "redirect:/admin/administrationpanel";
    }

    @GetMapping("/admin/add_admin/{userid}")
    public String setUserAsAdmin(@PathVariable("userid") Long id){
        userService.setUserAsAdmin(id);
        return "redirect:/admin/administrationpanel";
    }
}
