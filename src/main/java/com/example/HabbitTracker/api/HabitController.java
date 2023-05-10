package com.example.HabbitTracker.api;

import com.example.HabbitTracker.db.service.HabitService;
import com.example.HabbitTracker.db.service.serviceimpl.TrackingService;
import com.example.HabbitTracker.dto.request.HabitRequest;
import com.example.HabbitTracker.dto.request.TrackingRequest;
import com.example.HabbitTracker.dto.response.HabitResponse;

import com.example.HabbitTracker.dto.response.TrackingResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/habit")
public class HabitController {

    private final HabitService habitService;
    private final TrackingService trackingService;

    @GetMapping("/")
    public List<HabitResponse> getAll() {
        return habitService.getAll();
    }

    @PostMapping("/")
    public HabitResponse save(@RequestBody HabitRequest habitRequest) {
        return habitService.create(habitRequest);
    }

    @PutMapping("/{id}")
    public HabitResponse update(@PathVariable Long id, @RequestBody HabitRequest habitRequest) {
        return habitService.update(id, habitRequest);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return habitService.delete(id);
    }

    @PutMapping("/track")
    public TrackingResponse track(@RequestBody TrackingRequest trackingRequest) {
        return trackingService.track(trackingRequest);
    }

}