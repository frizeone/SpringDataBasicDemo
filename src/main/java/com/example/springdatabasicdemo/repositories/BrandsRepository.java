package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, UUID> {

    Optional<Brands> findByName (String name);


    @Modifying
    @Transactional
    void deleteByName(String name);
}
