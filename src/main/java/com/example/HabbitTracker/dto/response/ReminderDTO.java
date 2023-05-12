package com.example.HabbitTracker.dto.response;

import com.example.HabbitTracker.db.entities.Reminder;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
public class ReminderDTO {
    private Long id;
    private LocalTime localTime;
    private String message;
    private Duration repeatInterval;

}