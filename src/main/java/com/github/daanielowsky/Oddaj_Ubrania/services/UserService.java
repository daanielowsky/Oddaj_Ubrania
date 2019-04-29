package com.github.daanielowsky.Oddaj_Ubrania.services;


import com.github.daanielowsky.Oddaj_Ubrania.Repositories.UserRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.RegistrationFormDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.github.daanielowsky.Oddaj_Ubrania.services.Converter.*;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Transactional
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void registerUser(RegistrationFormDTO formDTO){
        User user = convertToUserFromDTO(formDTO);
        user.setPassword(passwordEncoder.encode(formDTO.getPassword()));
        userRepository.save(user);

    }


}
