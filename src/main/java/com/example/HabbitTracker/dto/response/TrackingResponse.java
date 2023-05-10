package com.example.HabbitTracker.dto.response;


import com.example.HabbitTracker.db.entities.Habit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Setter
@Getter
@NoArgsConstructor
public class TrackingResponse {

    private Long id;

    private int countingTheNumberOfCompletedDays;

    private int habitMeasurement;

    private LocalDate calendar;

}
