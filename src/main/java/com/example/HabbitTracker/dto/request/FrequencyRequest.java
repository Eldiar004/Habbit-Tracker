package com.example.HabbitTracker.dto.request;

import com.example.HabbitTracker.db.entities.Habit;
import com.example.HabbitTracker.db.entities.Reminder;
import com.example.HabbitTracker.db.entities.enums.ExecutionFrequency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Setter
@Getter
@NoArgsConstructor
public class FrequencyRequest {

    private ExecutionFrequency executionFrequency;

//    private List<Reminder> reminders;

}

