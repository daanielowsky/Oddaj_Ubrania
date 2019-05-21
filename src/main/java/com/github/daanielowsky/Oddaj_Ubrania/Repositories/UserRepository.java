package com.github.daanielowsky.Oddaj_Ubrania.Repositories;

import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
    User findFirstByEmailAndPassword(String email, String password);
    User findFirstByEmail(String email);
    List<User> findBy();
    List<User> findByRoles(String role);
    User getUserById(Long id);
    @Query(value = "select count(*) from User u", nativeQuery = true)
    int getAmountOfUsers();

    @Query(value = "SELECT * FROM user JOIN users_roles ON user.id=users_roles.user_id WHERE role_id = 2;", nativeQuery = true)
    List<User> getAllAdmins();

    @Query(value = "SELECT count(*) FROM user JOIN users_roles ON user.id=users_roles.user_id WHERE role_id = 2;", nativeQuery = true)
    int getAmountOfAdmins();

}
