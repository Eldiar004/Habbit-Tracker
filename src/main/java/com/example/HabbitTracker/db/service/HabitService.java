package com.example.HabbitTracker.db.service;

import com.example.HabbitTracker.dto.request.HabitRequest;
import com.example.HabbitTracker.dto.response.HabitResponse;
import com.example.HabbitTracker.dto.response.SimpleResponse;

import java.util.List;

public interface HabitService {

    List<HabitResponse> getAll();

    HabitResponse create(HabitRequest habitRequest);

    HabitResponse update(Long id, HabitRequest habitRequest);

    String delete(Long id);

}
