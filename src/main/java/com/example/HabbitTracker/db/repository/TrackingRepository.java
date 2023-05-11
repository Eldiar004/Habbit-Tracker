package com.example.HabbitTracker.db.repository;

import com.example.HabbitTracker.db.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    @Query("select count(*) from Tracking t where t.habit.id = :habitId")
    int countOfCompletedDays(@Param("habitId") int habitId);
}
