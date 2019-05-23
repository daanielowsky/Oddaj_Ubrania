package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository <Collection, Long> {
}
