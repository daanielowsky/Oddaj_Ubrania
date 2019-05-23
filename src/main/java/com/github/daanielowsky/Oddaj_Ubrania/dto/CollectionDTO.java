package com.github.daanielowsky.Oddaj_Ubrania.dto;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Data @AllArgsConstructor @NoArgsConstructor
public class CollectionDTO {

    @NotBlank
    private ArrayList<String> thingsToGiveaway;

    @NotBlank
    private Long numberOfPlasticBags;

    @NotBlank
    private String localization;

    @NotBlank
    private String whoWouldLikeToHelp;

    @NotBlank
    private Organizations organizations;

    @NotBlank
    private String street;

    @NotBlank
    private String postCode;

    @NotBlank
    private Integer phoneNumber;

    private String comments;

    @NotBlank
    private String dateOfPickup;

    @NotBlank
    private String hourOfPickup;

    @NotBlank
    private User user;
}
