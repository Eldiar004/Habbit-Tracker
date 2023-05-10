package com.example.HabbitTracker.db.service.serviceimpl;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ReminderService {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void scheduleReminder(Runnable task, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.DAYS);
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}

