package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
//   Optional<User> findByFirst_name (String first_name);
//
//    Users findByFirst_nameAndLast_name(String first_name, String last_name);
//
//    void deleteByFirst_nameAndLast_name (String first_name, String last_name);

    Optional<Users> findByUsername (String userName);
//
//    Optional<Users> findByFirst_name (String firstName);


}
