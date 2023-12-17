package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.enumPacage.Role;
import com.example.springdatabasicdemo.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RolseRepository extends JpaRepository<Roles, UUID> {

    Optional<Roles> findRolesByRole (Role role);

//    Optional<Roles> findRolesByN

}
