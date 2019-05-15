package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationsRepository extends JpaRepository <Organizations, Long> {

    @Query(value = "select count(*) from Organizations o", nativeQuery = true)
    int getAll();

    List<Organizations> getAllBy();
}
