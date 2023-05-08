package com.example.HabbitTracker.api;

import com.example.HabbitTracker.db.service.UserService;
import com.example.HabbitTracker.dto.request.AuthRequest;
import com.example.HabbitTracker.dto.request.ResetPasswordRequest;
import com.example.HabbitTracker.dto.request.SignUpRequest;
import com.example.HabbitTracker.dto.response.AuthResponse;
import com.example.HabbitTracker.dto.response.SimpleResponse;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final UserService userService;

    @PostMapping("/signup")
    public AuthResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return userService.singUp(request);
    }

    @PostMapping("/login")
    public AuthResponse signIn(@RequestBody @Valid AuthRequest request) {
        return userService.login(request);
    }

    @PostMapping("/forgot")
    public SimpleResponse forgotPassword(@RequestParam String email) throws MessagingException {
        return userService.forgotPassword(email);
    }

    @PutMapping("/")
    public SimpleResponse resetPassword(@RequestParam int verifyNumber, @RequestBody ResetPasswordRequest request) throws MessagingException {
        return userService.resetPassword(verifyNumber, request);
    }

}
