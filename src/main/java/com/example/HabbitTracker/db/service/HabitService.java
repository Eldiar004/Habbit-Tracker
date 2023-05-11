package com.example.HabbitTracker.db.service;

import com.example.HabbitTracker.dto.request.HabitRequest;
import com.example.HabbitTracker.dto.response.HabitResponse;
import org.quartz.JobExecutionException;

import java.util.List;

public interface HabitService {

    List<HabitResponse> getAll();

    HabitResponse create(HabitRequest habitRequest) throws JobExecutionException;

    HabitResponse update(Long id, HabitRequest habitRequest);

    String delete(Long id);

}
