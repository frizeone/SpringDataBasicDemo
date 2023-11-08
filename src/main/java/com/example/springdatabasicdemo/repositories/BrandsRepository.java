package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, UUID> {

}
