package com.example.webcalendar.services;

import com.example.webcalendar.DTOs.TaskDTO;
import com.example.webcalendar.entities.Task;
import com.example.webcalendar.entities.User;
import com.example.webcalendar.repos.TaskRepo;
import com.example.webcalendar.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * TaskService is a service class that provides methods for performing CRUD operations on Task entities.
 * It uses TaskRepo to interact with the database.
 */

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserRepo userRepo;

    /**
     * Saves a task to the database.
     *
     * @param taskDTO The task to save.
     * @return The saved task.
     */
    public Task save(TaskDTO taskDTO){
        Task task = new Task();
        task.setDate(taskDTO.getDate());
        task.setTime(taskDTO.getTime());
        task.setDescription(taskDTO.getDescription());
        User user = userRepo.findByUsername(taskDTO.getUsername()).get();
        task.setUser(user);
        return taskRepo.save(task);
    }

    /**
     * Deletes a task from the database by ID.
     *
     * @param id The ID of the task to delete.
     */
    public void deleteById(Long id){
        taskRepo.deleteById(id);
    }

    /**
     * Finds a task in the database by ID.
     *
     * @param id The ID of the task to find.
     * @return An Optional containing the found task, or an empty Optional if no task was found.
     */
    public Optional<Task> findById(Long id){
        return taskRepo.findById(id);
    }

    /**
     * Retrieves all tasks from the database.
     *
     * @return A List of all tasks in the database.
     */
    public List<Task> findAll(){
        return taskRepo.findAll();
    }

    public List<Task> findByDateAndUser(LocalDate date, String username){
        User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(""));
        return taskRepo.findAllByDateAndUser(date,user);
    }

    public void doComplete(Long id){
        Optional<Task> task = taskRepo.findById(id);
        task.get().setCompleted(true);
        taskRepo.save(task.get());
    }
}
