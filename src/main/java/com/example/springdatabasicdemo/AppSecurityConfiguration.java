package com.example.springdatabasicdemo;

import com.example.springdatabasicdemo.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSecurityConfiguration {

    private UserRepository userRepository;

    public AppSecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
