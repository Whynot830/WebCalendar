package com.example.webcalendar.controllers;

import com.example.webcalendar.DTOs.TaskDTO;
import com.example.webcalendar.entities.Task;
import com.example.webcalendar.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * TaskController is responsible for handling HTTP requests related to Task entities.
 * It uses TaskService to perform CRUD operations.
 */

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Returns a list of all tasks.
     *
     * @return the list of all tasks
     */
    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<Task>>  findByDateAndUser(@PathVariable String date, Authentication authentication){
        String username = authentication.getName();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date,formatter);
        return ResponseEntity.ok(taskService.findByDateAndUser(localDate,username));
    }

    @PostMapping("/{id}/complete")
    public void doComplete(@PathVariable Long id){
        taskService.doComplete(id);
    }

    /**
     * Saves a new task.
     *
     * @param taskDTO the task to be saved
     * @return the saved task
     */
    @PostMapping
    public Task save(@RequestBody TaskDTO taskDTO, Authentication authentication){
        taskDTO.setUsername(authentication.getName());
        return taskService.save(taskDTO);
    }

    /**
     * Deletes the task with the given ID.
     *
     * @param id the ID of the task to delete
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.deleteById(id);
    }
}
