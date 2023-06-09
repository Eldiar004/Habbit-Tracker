package com.example.HabbitTracker.db.repository;

import com.example.HabbitTracker.db.entities.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
