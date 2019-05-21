package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
    User findFirstByEmailAndPassword(String email, String password);
    User findFirstByEmail(String email);
    List<User> findBy();

}
