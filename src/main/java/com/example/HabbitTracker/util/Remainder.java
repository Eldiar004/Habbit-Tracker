package com.example.HabbitTracker.util;

import com.example.HabbitTracker.api.HabitController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Remainder implements Runnable{
    private HabitController habitController;

    public Remainder(String message) {

    }
    @Override
    public void run() {
        habitController.remind("");
    }
}
