package com.smarthealth.platform.service;

import com.smarthealth.platform.dto.*;
import com.smarthealth.platform.model.User;
import com.smarthealth.platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword()) // In real app, encrypt this
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .message("User registered successfully")
                .email(user.getEmail())
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return AuthResponse.builder()
                .message("Login successful")
                .email(user.getEmail())
                .build();
    }
}
