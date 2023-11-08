package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.enumPacage.Category;
import com.example.springdatabasicdemo.models.Brands;
import com.example.springdatabasicdemo.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelsRepository extends JpaRepository<Models, UUID> {



       Models findByName (String name);

       Models deleteByName (String name);

//    Получение всех моделей автомобилей для определенного бренда

       List<Models> findByBrands(Brands brand);




// Получение списка моделей по категории


       List<Models> findByCategory(Category category);

}
