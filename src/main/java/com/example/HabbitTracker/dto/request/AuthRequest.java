package com.example.HabbitTracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    @NotNull(message = "Password must not be null!")
    @NotBlank(message = "Password must not be empty!")
    @Email(message = "@gmail.com must be!")
    private String email;

    @NotNull(message = "Password must not be null!")
    @NotBlank(message = "Password must not be null!")
    private String password;

}
