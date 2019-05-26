package com.github.daanielowsky.Oddaj_Ubrania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @AllArgsConstructor @NoArgsConstructor
public class MessageDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    private String message;
}
