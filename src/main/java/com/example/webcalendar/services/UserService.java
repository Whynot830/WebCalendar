package com.example.webcalendar.services;

import com.example.webcalendar.entities.User;
import com.example.webcalendar.repos.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This service class provides methods for CRUD operations on User objects.
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    /**
     * Saves a User object in the repository.
     *
     * @param user the User object to save
     * @return the saved User object
     */
    public User save(User user){
        return userRepo.save(user);
    }

    /**
     * Deletes a User object from the repository by name.
     *
     * @param name the name of the User object to delete
     */
    @Transactional
    public void deleteByName(String name){
        userRepo.deleteByUsername(name);
    }

    /**
     * Finds a User object in the repository by name.
     *
     * @param name the name of the User object to find
     * @return the found User object, or null if not found
     */
    public Optional<User> findByName(String name){
        return userRepo.findByUsername(name);
    }

    /**
     * Retrieves all User objects from the repository.
     *
     * @return a List containing all User objects in the repository
     */
    public List<User> findAll(){
        return userRepo.findAll();
    }
}
