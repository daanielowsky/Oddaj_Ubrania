package com.github.daanielowsky.Oddaj_Ubrania.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Collections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String thingsToGiveaway;

    @Column(nullable = false)
    private Long numberOfPlasticBags;

    @Column(nullable = false)
    private String localization;

    @Column(nullable = false)
    private String whoWouldLikeToHelp;

    @ManyToOne
    private Organizations organizations;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private Long phoneNumber;

    private String comments;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String dateOfPickup;

    @Column(nullable = false)
    private String hourOfPickup;

    @ManyToOne
    private User user;

    private LocalDateTime created;

    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }


}
