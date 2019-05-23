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

    @NotEmpty
    private String thingsToGiveaway;

    @NotNull
    private Long numberOfPlasticBags;

    @NotEmpty
    private String localization;

    @NotEmpty
    private String city;

    @NotEmpty
    private String whoWouldLikeToHelp;

    @NotEmpty
    private Organizations organizations;

    @NotEmpty
    private String street;

    @NotEmpty
    private String postCode;

    @NotEmpty
    private Long phoneNumber;

    @NotEmpty
    private String comments;

    @NotEmpty
    private String dateOfPickup;

    @NotEmpty
    private String hourOfPickup;

    private User user;
}
