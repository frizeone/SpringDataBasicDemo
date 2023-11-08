package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enumPacage.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import java.util.UUID;

public class RolesDTO {

    private UUID id;

    @NotNull(message = "Роль не может быть null")
    @Enumerated
    private Role role;

    public RolesDTO(UUID id, Role role) {
        this.id = id;
        this.role = role;
    }

    public RolesDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RolesDTO{"+"role=" + role + '}';
    }
}
