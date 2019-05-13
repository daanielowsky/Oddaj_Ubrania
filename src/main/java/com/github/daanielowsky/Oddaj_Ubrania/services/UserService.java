package com.github.daanielowsky.Oddaj_Ubrania.services;


import com.github.daanielowsky.Oddaj_Ubrania.Repositories.RoleRepository;
import com.github.daanielowsky.Oddaj_Ubrania.Repositories.UserRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.RegistrationFormDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Role;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.github.daanielowsky.Oddaj_Ubrania.services.Converter.*;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private RoleService roleService;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleService = roleService;
    }


    @Transactional
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void registerUser(RegistrationFormDTO formDTO){
        User user = convertToUserFromDTO(formDTO);
        user.setPassword(passwordEncoder.encode(formDTO.getPassword()));
        List<Role> roles = user.getRoles();
        roles.add(roleService.gettingUserRole());
        user.setRoles(roles);
        userRepository.save(user);

    }

    @Transactional
    public User getLoggerUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findFirstByEmail(name);
    }


}
