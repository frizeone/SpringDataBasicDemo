package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BrandsController {


    private BrandsService brandsSevices;

    @Autowired
    public void setBrandsSevices (BrandsService brandsService){
        this.brandsSevices = brandsService;

    }


    @PostMapping("brand/add")
    public ResponseEntity<BrandsDTO> addNewBrand(@RequestBody BrandsDTO brandsDTO){
        return new ResponseEntity<>(brandsSevices.addNewBrand(brandsDTO), HttpStatus.OK);
    }

    @GetMapping("brand/getOne/{id}")
    public ResponseEntity<BrandsDTO> takeOneById (@PathVariable UUID id){
        BrandsDTO brandsDTO = brandsSevices.getBrandById(id);
        if(brandsDTO != null){
            return new ResponseEntity<>(brandsDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("brand/getAll")
    public ResponseEntity<List<BrandsDTO>> getAllBrands(){
        List<BrandsDTO> brandList = brandsSevices.getAllBrands();
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }

    @PutMapping("brand/updateBrand/{id}")
    public ResponseEntity<BrandsDTO> updateBrand (@PathVariable UUID id, @RequestBody BrandsDTO brandsDTO){
        BrandsDTO updateBrand = brandsSevices.updateBrand(id, brandsDTO);
        if (updateBrand != null){
            return new ResponseEntity<>(updateBrand, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateBrand, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("brand/delete/{id}")
    public ResponseEntity<Void> deleteBrands (@PathVariable UUID id){
        brandsSevices.deleteBrands(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
