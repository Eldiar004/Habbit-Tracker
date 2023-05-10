package com.example.HabbitTracker.db.repository;

import com.example.HabbitTracker.db.entities.Habit;
import com.example.HabbitTracker.db.entities.Tracking;
import com.example.HabbitTracker.dto.response.HabitResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.sound.midi.Track;
import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

    @Query("select new com.example.HabbitTracker.dto.response.HabitResponse(h.id, h.name, h.description, h.goal, h.startDate, h.endDate) from Habit h")
    List<HabitResponse> getAll();

    @Query("select new com.example.HabbitTracker.dto.response.HabitResponse(h.id, h.name, h.description, h.goal, h.startDate, h.endDate) from Habit h where h.id = :id")
    HabitResponse convertForUpdateMethod(@Param("id") Long id);

}