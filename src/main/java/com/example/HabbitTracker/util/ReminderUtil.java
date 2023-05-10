package com.example.HabbitTracker.util;

import com.example.HabbitTracker.api.HabitController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@RequiredArgsConstructor
public class ReminderUtil implements Runnable{
    private final HabitController habitController;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        habitController.remind(message);
    }
}
