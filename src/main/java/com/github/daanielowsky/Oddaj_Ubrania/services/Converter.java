package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.dto.RegistrationFormDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;

public class Converter {

    public static User convertToUserFromDTO(RegistrationFormDTO form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        return user;

    }
}
