package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.repositories.RolseRepository;
import com.example.springdatabasicdemo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private RolseRepository rolseRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RolseRepository rolseRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolseRepository = rolseRepository;
        this.passwordEncoder = passwordEncoder;
    }



}
