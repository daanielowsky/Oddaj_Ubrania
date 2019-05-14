package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationsRepository extends JpaRepository <Organizations, Long> {
}
