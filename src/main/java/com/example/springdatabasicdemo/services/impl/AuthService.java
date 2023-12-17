package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.RegisterDTO;
import com.example.springdatabasicdemo.dtos.RolesDTO;
import com.example.springdatabasicdemo.enumPacage.Role;
import com.example.springdatabasicdemo.models.Roles;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.RolseRepository;
import com.example.springdatabasicdemo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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

    public void register(RegisterDTO registerDTO){

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword()))
        {
            throw new RuntimeException("passwords.match");
        }

        var userRole = rolseRepository.findRolesByRole(Role.User).orElseThrow();

        Optional<Users> byUsername = this.userRepository.findByUsername(registerDTO.getUsername());


        if (byUsername.isPresent()) {
            throw new RuntimeException("Username is already taken!");
        }



        Users user = new Users(
                true,
                registerDTO.getFirst_name(),
                registerDTO.getLast_name(),
                passwordEncoder.encode(registerDTO.getPassword()),
                registerDTO.getUsername()
        );


        user.setRoles(userRole);


        this.userRepository.save(user);


    }

    public Users getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }

}
