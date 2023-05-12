package com.example.HabbitTracker.db.service.serviceimpl;

import com.example.HabbitTracker.db.entities.Habit;
import com.example.HabbitTracker.db.entities.Reminder;
import com.example.HabbitTracker.db.repository.HabitRepository;
import com.example.HabbitTracker.db.repository.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository repository;
    private final HabitRepository habitRepository;
    private final TaskScheduler taskScheduler;

    public void save(Reminder reminder) {
        repository.save(reminder);
    }

}

