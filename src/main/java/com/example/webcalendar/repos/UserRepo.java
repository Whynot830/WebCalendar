package com.example.webcalendar.repos;

import com.example.webcalendar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The UserRepo interface provides CRUD functionality for the User entity.
 */
public interface UserRepo extends JpaRepository<User,Long> {

    /**
     * Deletes a user by their name.
     *
     * @param name the name of the user to delete
     */
    void deleteByUsername(String name);

    /**
     * Finds a user by their name.
     *
     * @param name the name of the user to find
     * @return the user with the given name, or null if no user is found
     */
   Optional<User> findByUsername(String name);
}
