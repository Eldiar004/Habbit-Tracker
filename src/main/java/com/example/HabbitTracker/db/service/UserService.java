package com.example.HabbitTracker.db.service;

import com.example.HabbitTracker.dto.request.AuthRequest;
import com.example.HabbitTracker.dto.request.ResetPasswordRequest;
import com.example.HabbitTracker.dto.request.SignUpRequest;
import com.example.HabbitTracker.dto.response.AuthResponse;
import com.example.HabbitTracker.dto.response.SimpleResponse;
import jakarta.mail.MessagingException;


public interface UserService {

    AuthResponse singUp(SignUpRequest singUpRequest);

    AuthResponse login(AuthRequest authRequest);

    SimpleResponse forgotPassword(String email) throws MessagingException;

    SimpleResponse resetPassword(int verifyNumber, ResetPasswordRequest request);

}
