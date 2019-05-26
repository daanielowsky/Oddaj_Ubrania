package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Messages, Long> {

    List<Messages> getAllBy();

    Messages getMessageById(Long id);

    Long countAllBy();
}
