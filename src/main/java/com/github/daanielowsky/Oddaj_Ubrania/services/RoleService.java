package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.Repositories.RoleRepository;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role gettingUserRole(){
        Optional<Role> optionalRole = roleRepository.findByRole("ROLE_USER");
        Role role = optionalRole.orElse(null);

        if (role == null) {
            logger.info("Nie znaleziono roli użytkownika");
            return null;
        }
        return role;
    }
}
