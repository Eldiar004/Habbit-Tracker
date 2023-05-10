package com.example.HabbitTracker.dto.request;

import com.example.HabbitTracker.db.entities.Frequency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HabitRequest {

    private String name;

    private String description;

    private Integer goal;

    private LocalDate startDate;

    private LocalDate endDate;

    private FrequencyRequest frequency;

}
