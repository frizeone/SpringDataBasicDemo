package com.example.springdatabasicdemo.controllers;


import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.dtos.OffersDTO;
import com.example.springdatabasicdemo.models.Offers;
import com.example.springdatabasicdemo.services.OffersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public class OffersController {


    private final OffersService offersService;

    public OffersController (OffersService offersService){
        this.offersService = offersService;
    }


    @PostMapping("offers/add")
    public ResponseEntity<OffersDTO> addNewOffers(@RequestBody OffersDTO offersDTO){
        return new ResponseEntity<>(offersService.newOffers(offersDTO), HttpStatus.OK);
    }

    @GetMapping("offers/getOne/{id}")
    public ResponseEntity<OffersDTO> getOffersById (@PathVariable UUID id){
        OffersDTO offersDto = offersService.getOfferById(id);
        if (offersDto != null){
            return new ResponseEntity<>(offersDto, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(offersDto, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("offers/getAll")
    public  ResponseEntity<List<OffersDTO>> getAllOffers (){
        List<OffersDTO> offersDTOList = offersService.getAllOffers();
        return new ResponseEntity<>(offersDTOList, HttpStatus.OK);
    }

    @PutMapping("offers/updateModels/{id}")
    public ResponseEntity<OffersDTO> updateOffersById (UUID id, OffersDTO offersDTO){
        OffersDTO updateOffers = offersService.updateOffers(id, offersDTO);

        if (updateOffers != null){
            return new ResponseEntity<>(updateOffers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(updateOffers, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("offers/delete/{id}")
    public ResponseEntity<Void> deleteOffersById (@PathVariable UUID id){
        offersService.deleteOffers(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
