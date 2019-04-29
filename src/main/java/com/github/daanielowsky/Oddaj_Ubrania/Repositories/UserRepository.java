package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

}
