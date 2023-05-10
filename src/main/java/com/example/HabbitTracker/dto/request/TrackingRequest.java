package com.example.HabbitTracker.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackingRequest {

    private Long habitId;

    private Integer count;

    private Integer days;
}
