package com.github.daanielowsky.Oddaj_Ubrania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrganizationsDTO {


    @NotBlank @Size(min = 5)
    private String name;
}
