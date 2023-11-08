package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Offers;
import com.example.springdatabasicdemo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OffersRepository extends JpaRepository<Offers, UUID> {
//    Получение всех офферов от определенного пользователя

    List<Offers> findByUsers(Users users);

}
