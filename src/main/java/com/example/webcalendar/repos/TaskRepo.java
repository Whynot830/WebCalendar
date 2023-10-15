package com.example.webcalendar.repos;

import com.example.webcalendar.entities.Task;
import com.example.webcalendar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface represents the repository for Task entities.
 */
@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findAllByDateAndUser(LocalDate date, User user);
}
