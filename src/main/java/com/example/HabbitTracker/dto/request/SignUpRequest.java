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
public class SignUpRequest {

    @NotNull(message = "Name must not be null!")
    @NotBlank(message = "Name must not be empty!")
    private String name;

    @NotNull(message = "Last name must not be null!")
    @NotBlank(message = "Last name must not be empty!")
    private String lastname;

    @NotNull(message = "Email must not be null!")
    @NotBlank(message = "Email must not be empty!")
    @Email(message = "@gmail.com must be!")
    private String email;

    @NotNull(message = "Password must not be null!")
    @NotBlank(message = "Password must not be empty!")
    private String password;

    private String link;

}
