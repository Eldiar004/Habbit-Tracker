package com.example.HabbitTracker.db.entities;

import com.example.HabbitTracker.db.entities.enums.Ranks;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "achievements")
@Setter
@Getter
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(generator = "achievement_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "achievement_gen", sequenceName = "achievement_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Ranks ranks;

    private String description;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private User user;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH})
    @JoinTable(name = "habits_achievements",
            joinColumns = @JoinColumn(name = "habit_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private List<Habit> habits;

}

