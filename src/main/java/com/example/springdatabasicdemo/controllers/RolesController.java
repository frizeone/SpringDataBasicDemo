package com.example.springdatabasicdemo.controllers;


import com.example.springdatabasicdemo.dtos.RolesDTO;
import com.example.springdatabasicdemo.enumPacage.Role;
import com.example.springdatabasicdemo.models.Roles;
import com.example.springdatabasicdemo.repositories.RolseRepository;
import com.example.springdatabasicdemo.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class RolesController {


    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService){
        this.rolesService = rolesService;

    }

//    @PostMapping("roles/create")
//    RolesDTO newRoles (@RequestBody RolesDTO rolseDTO){
//        return rolesService.createdRoles(rolseDTO);
//    }

    @PostMapping("roles/create")
    public ResponseEntity<RolesDTO> newRolse (@RequestBody RolesDTO rolesDTO){
        return new ResponseEntity<>(rolesService.createdRoles(rolesDTO), HttpStatus.CREATED);
    }

//    @GetMapping("roles/getById/{id}")
//    RolesDTO takeRolse (@PathVariable int id) throws Throwable{
//        return rolesService.getRoleById(id);
//    }

    @GetMapping("roles/getById/{id}")
    public ResponseEntity<RolesDTO> takeRolse (@PathVariable int id){
       RolesDTO rolesDTO = rolesService.getRoleById(id);
       if ( rolesDTO != null){
           return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
       }else{
           return  new ResponseEntity<>(rolesDTO, HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("roles/getAll")
    public ResponseEntity<List<RolesDTO>> getAllRolse (){
        List<RolesDTO> listRolse = rolesService.getAllRoles();
        return new ResponseEntity<>(listRolse, HttpStatus.OK);
    }


    @PutMapping("roles/update/{id}")
    public ResponseEntity<RolesDTO> updateRolse(@PathVariable int id, @RequestBody RolesDTO rolesDTO){
        RolesDTO updateRolse = rolesService.updateRoles(id, rolesDTO);
        if (updateRolse != null){
            return new ResponseEntity<>(updateRolse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateRolse, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("rolse/delete/{id}")
    public ResponseEntity<RolesDTO> deleteRolse(@PathVariable int id){
        rolesService.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
