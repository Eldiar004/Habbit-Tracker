package com.example.HabbitTracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull(message = "Name must not be null!")
    @NotBlank(message = "Name must not be empty!")
    private String firstName;

    @NotNull(message = "Last name must not be null!")
    @NotBlank(message = "Last name must not be empty!")
    private String lastname;

}
