package com.github.daanielowsky.Oddaj_Ubrania.dto;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data @AllArgsConstructor @NoArgsConstructor
public class CollectionDTO {

    @NotNull
    private String thingsToGiveaway;

    @NotNull
    private Long numberOfPlasticBags;

    @NotNull
    private String localization;

    @NotNull
    private String city;

    @NotNull
    private String whoWouldLikeToHelp;

    @NotNull
    private Organizations organizations;

    @NotNull
    private String street;

    @NotNull
    private String postCode;

    @NotNull
    private Long phoneNumber;

    private String comments;

    @NotNull
    private String dateOfPickup;

    @NotNull
    private String hourOfPickup;

    private User user;
}
