package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.dto.CollectionDTO;
import com.github.daanielowsky.Oddaj_Ubrania.dto.RegistrationFormDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Collections;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.hibernate.mapping.Collection;

public class Converter {

    public static User convertToUserFromDTO(RegistrationFormDTO form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        return user;

    }

    public static Collection convertToCollectionFromDTO(CollectionDTO dto){
        Collections collections = new Collections();
        collections.setCity(dto.getCity());
        collections.setComments(dto.getComments());
        
    }
}
