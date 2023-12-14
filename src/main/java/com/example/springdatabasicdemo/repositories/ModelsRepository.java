package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.enumPacage.Category;
import com.example.springdatabasicdemo.models.Brands;
import com.example.springdatabasicdemo.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ModelsRepository extends JpaRepository<Models, UUID> {

       @Query("select m from Models m where m.name = :name and m.startYear = :startYear and m.endYear = :endYear")
       Models findModelsByNameAndStartYearAndEndYear (String name, int startYear, int endYear);

       @Query("select m from Models m where m.id in (select o.model.id from Offers o group by o.model.id order by count (o.model.id) desc limit 3)")
       List<Models> findTopThree ();

       Models findByName (String name);

       Models deleteByName (String name);
       @Modifying
       @Query("delete from Models m where m.name = :name and m.startYear = :startYear  and m.endYear = :endYear ")
       void deleteModelsByNameAndStartYearAndEndYear (String name, int startYear, int endYear);

//    Получение всех моделей автомобилей для определенного бренда

       List<Models> findByBrands(Brands brand);




// Получение списка моделей по категории


       List<Models> findByCategory(Category category);

}
