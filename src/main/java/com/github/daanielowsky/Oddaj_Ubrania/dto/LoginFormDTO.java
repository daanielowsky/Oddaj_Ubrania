package com.github.daanielowsky.Oddaj_Ubrania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoginFormDTO {

    @Email
    private String email;

    @NotNull
    private String password;
}
