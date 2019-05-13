package com.github.daanielowsky.Oddaj_Ubrania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor
public class PasswordDTO {

    @NotNull
    @Size(min = 8, max = 20)
    private String oldPassword;
    @NotNull
    @Size(min = 8, max = 20)
    private String password;
    @NotNull
    @Size(min = 8, max = 20)
    private String confirmedPassword;
}
