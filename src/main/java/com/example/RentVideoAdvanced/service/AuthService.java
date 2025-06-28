package com.example.RentVideoAdvanced.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RentVideoAdvanced.entity.User;
import com.example.RentVideoAdvanced.entity.enums.Role;
import com.example.RentVideoAdvanced.exchanges.request.AuthRequest;
import com.example.RentVideoAdvanced.exchanges.request.RegisterRequest;
import com.example.RentVideoAdvanced.exchanges.response.AuthResponse;
import com.example.RentVideoAdvanced.repository.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (request.getRole() == null) {
            request.setRole(Role.CUSTOMER);
        }

        User user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole())
            .build();

        userRepository.save(user);
        
        return AuthResponse.builder().build();
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        return AuthResponse.builder().build();
    }
}
