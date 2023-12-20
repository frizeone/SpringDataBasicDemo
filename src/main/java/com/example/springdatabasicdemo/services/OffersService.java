package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OffersDTO;
import com.example.springdatabasicdemo.dtos.UserDTO;

import java.util.List;
import java.util.UUID;

public interface OffersService <ID>{
    OffersDTO newOffers(OffersDTO offersDTO);



    void register(OffersDTO offer);

    OffersDTO getOfferById(int id);

    OffersDTO getOfferById(UUID id);

    List<OffersDTO> getAllOffers();

    OffersDTO updateOffers(int id, OffersDTO offersDTO);

    OffersDTO updateOffers(UUID id, OffersDTO offersDTO);

    void deleteOffers(int id);

    void deleteOffers(UUID id);

    List<OffersDTO> getAllOffersByUsers (UserDTO userDTO);
}
