package com.example.springdatabasicdemo.controllers;


import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Manager")
public class ManagerController {

    @GetMapping("/Profile")
    public String managerPage (){
        return "Manager";
    }





}
