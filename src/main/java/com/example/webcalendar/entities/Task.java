package com.example.webcalendar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Task is an entity class that represents a task which is associated with a specific day.
 * It has a many-to-one relationship with Day entity.
 */

@Entity
@Data
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The time of the task.
     */
    @Column(name = "time")
    private LocalTime time;

    /**
     * The description of the task.
     */
    @Column(name = "description")
    private String description;

    /**
     * The date that this task belongs to.
     */
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @Column(name = "completed")
    private Boolean completed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private User user;
}
