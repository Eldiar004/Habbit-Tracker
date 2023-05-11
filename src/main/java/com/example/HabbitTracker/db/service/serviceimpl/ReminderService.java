package com.example.HabbitTracker.db.service.serviceimpl;

import com.example.HabbitTracker.db.entities.Reminder;
import com.example.HabbitTracker.db.repository.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository repository;

    public void save(Reminder reminder) {
        repository.save(reminder);
    }
}

