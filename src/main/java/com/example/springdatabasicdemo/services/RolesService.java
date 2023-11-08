package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.RolesDTO;

import java.util.List;
import java.util.UUID;

public interface RolesService <ID>{
    RolesDTO createdRoles(RolesDTO rolesDTO);

    RolesDTO getRoleById(int id);

    RolesDTO getRoleById(UUID id);

    List<RolesDTO> getAllRoles();

    RolesDTO updateRoles(int id, RolesDTO rolesDTO);

    RolesDTO updateRoles(UUID id, RolesDTO rolesDTO);

    void deleteRoleById(int id);

    void deleteRoleById(UUID id);
}
