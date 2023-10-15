package com.example.webcalendar.controllers;

import com.example.webcalendar.entities.User;
import com.example.webcalendar.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 The UserController class provides RESTful endpoints for CRUD operations and login/registration of User entities.
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return List of User objects
     */
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * Retrieves a user by username.
     *
     * @param name the username of the user to retrieve
     * @return the User object if it exists, null otherwise
     */
    @GetMapping("/{name}")
    public User findById(@PathVariable String name){
        return userService.findByName(name).get();
    }

    /**
     * Deletes a user by username.
     *
     * @param name the username of the user to delete
     */
    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable String name){
        userService.deleteByName(name);
    }

}
