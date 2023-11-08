package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.dtos.OffersDTO;
import com.example.springdatabasicdemo.dtos.UserDTO;
import com.example.springdatabasicdemo.models.Offers;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.OffersRepository;
import com.example.springdatabasicdemo.services.OffersService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OffersServiceImpl implements OffersService<UUID> {
    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OffersDTO newOffers(OffersDTO offersDTO){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<OffersDTO>> violations = validator.validate(offersDTO);

        if (!violations.isEmpty()){
            for (ConstraintViolation<OffersDTO> violation : violations) {
                System.out.println("Ошибка валидации: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
            return null;
        }else {

            Offers offers = modelMapper.map(offersDTO, Offers.class);
            return modelMapper.map(offersRepository.save(offers), OffersDTO.class);
        }
    }

    @Override
    public OffersDTO getOfferById(int id) {
        return null;
    }

    @Override
    public OffersDTO getOfferById(UUID id){
        Optional<Offers> offers = offersRepository.findById(id);
        return offers.map(object -> modelMapper.map(object, OffersDTO.class)).orElse(null);
    }

    @Override
    public List<OffersDTO> getAllOffers(){
        List<Offers> offersList = offersRepository.findAll();
        return offersList.stream().map(offers -> modelMapper.map(offers, OffersDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OffersDTO updateOffers(int id, OffersDTO offersDTO) {
        return null;
    }

    @Override
    public OffersDTO updateOffers(UUID id, OffersDTO offersDTO){
        Offers currentOffers = offersRepository.findById(id).orElse(null);
        if (currentOffers != null){
            modelMapper.map(offersDTO, currentOffers);
            return modelMapper.map(offersRepository.save(currentOffers), OffersDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteOffers(int id) {

    }

    @Override
    public void deleteOffers(UUID id){
        offersRepository.deleteById(id);
    }


    @Override
    public List<OffersDTO> getAllOffersByUsers (UserDTO userDTO){
        Users users = modelMapper.map(userDTO, Users.class);
        List<Offers> offersList = offersRepository.findByUsers(users);
        return offersList.stream().map(offer -> modelMapper.map(offer, OffersDTO.class)).collect(Collectors.toList());
    }
}
