package com.example.webcalendar.DTOs;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TaskDTO {
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String username;
}
