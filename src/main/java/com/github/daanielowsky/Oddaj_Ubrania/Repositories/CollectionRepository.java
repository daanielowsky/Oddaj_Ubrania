package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Collections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectionRepository extends JpaRepository <Collections, Long> {

    @Query(value = "select * from collections where user_id = ? order by created desc", nativeQuery = true)
    List<Collections> getSortedListOfCollections(Long id);
}
