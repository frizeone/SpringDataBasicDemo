package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService <ID>{
    UserDTO newUser(UserDTO userDTO);

    UserDTO getUserById(int id);

    UserDTO getUserById(UUID id);

    UserDTO getUserByName(String first_name);

    List<UserDTO> getAllUsers();

    UserDTO updateUsers(int id, UserDTO userDTO);

    UserDTO updateUsers(UUID id, UserDTO userDTO);

    UserDTO apdateUsersByName(String first_name, String last_Name, UserDTO userDTO);

    void deleteUsers(int id);

    void deleteUsers(UUID id);

    void deleteUsersBuNameAndSeconName(String first_name, String last_name);
}
