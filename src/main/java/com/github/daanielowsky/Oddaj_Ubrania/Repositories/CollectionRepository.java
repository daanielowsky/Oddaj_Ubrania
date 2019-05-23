package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Collections;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository <Collections, Long> {
}
