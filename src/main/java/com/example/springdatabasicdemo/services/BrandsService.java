package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandsDTO;

import java.util.List;
import java.util.UUID;

public interface BrandsService<ID> {
    BrandsDTO addNewBrand(BrandsDTO brandsDTO);

    BrandsDTO getBrandById(int id);

    BrandsDTO getBrandById(UUID id);

    List<BrandsDTO> getAllBrands();

    BrandsDTO updateBrand(int id, BrandsDTO brandsDTO);

    BrandsDTO updateBrand(UUID id, BrandsDTO brandsDTO);

    void deleteBrands(int id);

    void deleteBrands(UUID id);
}
