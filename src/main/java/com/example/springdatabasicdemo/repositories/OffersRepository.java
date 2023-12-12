package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Offers;
import com.example.springdatabasicdemo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Repository
public interface OffersRepository extends JpaRepository<Offers, UUID> {
//    Получение всех офферов от определенного пользователя

    List<Offers> findByUsers(Users users);

  /*  @Query("SELECT o.model.id, COUNT(o) as offerCount " +
            "FROM OffersDTO o " +
            "GROUP BY o.model.id " +
            "ORDER BY offerCount DESC")
    List<Object[]> findTopModelsByOfferCount(Pageable pageable);
*/
}
