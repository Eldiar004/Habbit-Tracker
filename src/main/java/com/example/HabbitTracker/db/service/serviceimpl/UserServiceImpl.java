package com.example.HabbitTracker.db.service.serviceimpl;

import com.example.HabbitTracker.config.jwt.JwtTokenProvider;
import com.example.HabbitTracker.db.entities.User;
import com.example.HabbitTracker.db.repository.UserRepository;
import com.example.HabbitTracker.db.service.UserService;
import com.example.HabbitTracker.dto.request.AuthRequest;
import com.example.HabbitTracker.dto.request.ResetPasswordRequest;
import com.example.HabbitTracker.dto.request.SignUpRequest;
import com.example.HabbitTracker.dto.response.AuthResponse;
import com.example.HabbitTracker.dto.response.SimpleResponse;
import com.example.HabbitTracker.exceptions.BadCredentialsException;
import com.example.HabbitTracker.exceptions.BadRequestException;
import com.example.HabbitTracker.exceptions.NotFoundException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

//    private final CodeRepository codeRepository;

    private final JavaMailSender javaMailSender;

    private int randomNumber;

    @Override
    public AuthResponse singUp(SignUpRequest singUpRequest) {
        if (!userRepository.existsByEmail(singUpRequest.getEmail())) {
            User user = new User();

            user.setFirstname(singUpRequest.getName());
            user.setLastname(singUpRequest.getLastname());
            user.setEmail(singUpRequest.getEmail());
            user.setPassword(passwordEncoder.encode(singUpRequest.getPassword()));
            user.setLink(singUpRequest.getLink());

            userRepository.save(user);

            return new AuthResponse(user.getId(),
                    user.getFirstname(),
                    user.getLastname(),
                    user.getEmail(),
                    jwtTokenProvider.generateToken(user.getEmail()));

        } else {
            throw new BadRequestException(String.format("This %s already exists!", singUpRequest.getEmail()));
        }
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(
                () -> new NotFoundException(String.format("User with %s not found!", authRequest.getEmail()))
        );

        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {

            return new AuthResponse(user.getId(),
                    user.getUsername(),
                    user.getLastname(),
                    user.getEmail(),
                    jwtTokenProvider.generateToken(user.getEmail()));

        } else {
            throw new BadCredentialsException("This password already exists!");
        }
    }

    @Override
    public SimpleResponse forgotPassword(String email) throws MessagingException{
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException(String.format("User with email: %s not found!", email))
        );

        randomNumber = new Random().nextInt(100000, 999999);
        user.setCode(randomNumber);
        userRepository.save(user);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setSubject("Habit Tracker");
        helper.setTo(email);
        helper.setText("This is a four digit verification code.: " + randomNumber);
        javaMailSender.send(mimeMessage);

        return new SimpleResponse("You have been sent a verification code!");
    }

    @Override
    public SimpleResponse resetPassword(int verifyNumber, ResetPasswordRequest request) {
        if (verifyNumber != randomNumber) {
            throw new BadCredentialsException(String.format("Unfortunately this code: %d is not correct", verifyNumber));
        }

        User user = userRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException(String.format("User with id: %d not found!", request.getId()))
        );

        String newPassword = passwordEncoder.encode(request.getNewPassword());

        if (user.getPassword().equals(newPassword)) {
            throw new BadRequestException("The password cannot be a duplicate!");
        } else {
            user.setPassword(newPassword);
            userRepository.save(user);
            return new SimpleResponse("Password updated successfully!");
        }

    }

}
