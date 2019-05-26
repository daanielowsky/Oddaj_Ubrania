package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.dto.CollectionDTO;
import com.github.daanielowsky.Oddaj_Ubrania.dto.MessageDTO;
import com.github.daanielowsky.Oddaj_Ubrania.dto.RegistrationFormDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Collections;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Messages;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;


public class Converter {

    public static User convertToUserFromDTO(RegistrationFormDTO form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        return user;

    }

    public static Collections convertToCollectionFromDTO(CollectionDTO dto){
        Collections collections = new Collections();
        collections.setCity(dto.getCity());
        collections.setComments(dto.getComments());
        collections.setDateOfPickup(dto.getDateOfPickup());
        collections.setOrganizations(dto.getOrganizations());
        collections.setHourOfPickup(dto.getHourOfPickup());
        collections.setLocalization(dto.getLocalization());
        collections.setNumberOfPlasticBags(dto.getNumberOfPlasticBags());
        collections.setPhoneNumber(dto.getPhoneNumber());
        collections.setThingsToGiveaway(dto.getThingsToGiveaway());
        collections.setWhoWouldLikeToHelp(dto.getWhoWouldLikeToHelp());
        collections.setPostCode(dto.getPostCode());
        collections.setStreet(dto.getStreet());
        return collections;
    }

    public static Messages convertToMessagesFromDTO(MessageDTO dto){
        Messages messages = new Messages();
        messages.setEmail(dto.getEmail());
        messages.setLastname(dto.getSurname());
        messages.setName(dto.getName());
        messages.setMessage(dto.getMessage());
        return messages;
    }
}
