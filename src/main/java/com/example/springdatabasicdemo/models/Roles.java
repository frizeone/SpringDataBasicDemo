package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.enumPacage.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles extends BaseEntity{

//    @Column(name = "name")
//    @Enumerated(EnumType.ORDINAL)
    private Role role;


    public Roles(Role role) {
        this.role = role;
    }

    public Roles() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
//
//    @Override
//    public String toString() {
//        return "Student { id=" + id + ", name=" + role + " }";
//    }
}
