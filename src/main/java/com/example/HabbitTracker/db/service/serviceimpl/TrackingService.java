package com.example.HabbitTracker.db.service.serviceimpl;

import com.example.HabbitTracker.db.entities.Habit;
import com.example.HabbitTracker.db.entities.Tracking;
import com.example.HabbitTracker.db.repository.HabitRepository;
import com.example.HabbitTracker.db.repository.TrackingRepository;
import com.example.HabbitTracker.dto.request.TrackingRequest;
import com.example.HabbitTracker.dto.response.TrackingResponse;
import com.example.HabbitTracker.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TrackingService {
    private final TrackingRepository trackingRepository;
    private final HabitRepository habitRepository;

    public TrackingResponse track(TrackingRequest trackingRequest) {
        Long id = trackingRequest.getHabitId();
        Habit habit = habitRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Habit with id: %d not found!", id))
        );
        Tracking tracking = new Tracking();
        tracking.setHabit(habit);
        tracking.setCalendar(LocalDate.now());
        tracking.setCountingTheNumberOfCompletedDays(trackingRequest.getDays());
        tracking.setHabitMeasurement(trackingRequest.getCount());
        trackingRepository.save(tracking);
        TrackingResponse trackingResponse = new TrackingResponse();
        trackingResponse.setId(tracking.getId());
        trackingResponse.setCalendar(tracking.getCalendar());
        trackingResponse.setHabitMeasurement(tracking.getHabitMeasurement());
        trackingResponse.setCountingTheNumberOfCompletedDays(tracking.getCountingTheNumberOfCompletedDays());
        return trackingResponse;
    }
    public int getCountOfCompletedDays(int habitId) {
        return trackingRepository.countOfCompletedDays(habitId);
    }
}
