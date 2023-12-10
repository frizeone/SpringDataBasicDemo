package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.dtos.UserDTO;
import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UsersController {


    private final UserService userService;

    @Autowired
    public UsersController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("users/add")
    public ResponseEntity<UserDTO> addNewUser (@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.newUser(userDTO), HttpStatus.OK);
    }

//    @GetMapping("users/getOne/{name}")
//    public ResponseEntity<UserDTO> getOneUsersByName (@PathVariable String name){
//        UserDTO userDTO = userService.getUserByName(name);
//        if (userDTO != null){
//            return new ResponseEntity<>(userDTO, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("users/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers (){
        List<UserDTO> usersList = userService.getAllUsers();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

//    @PutMapping("users/updateUsers/{first_name}/{last_name}")
//    public ResponseEntity<UserDTO> updateUsersByName (@PathVariable String first_name,@PathVariable String last_name, @RequestBody UserDTO userDTO){
//        UserDTO updateUsers = userService.apdateUsersByName(first_name, last_name, userDTO);
//        if (updateUsers != null){
//            return new ResponseEntity<>(updateUsers, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(updateUsers, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("users/deleteUser/{first_name}/{last_name}")
//    public ResponseEntity<Void> deleteUsersBuNameAndLastname (@PathVariable String first_name, @PathVariable String last_name){
//        userService.deleteUsersBuNameAndSeconName(first_name, last_name);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


}
