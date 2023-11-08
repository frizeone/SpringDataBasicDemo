package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.models.Brands;
import com.example.springdatabasicdemo.repositories.BrandsRepository;
import com.example.springdatabasicdemo.services.BrandsService;
import com.example.springdatabasicdemo.util.ValidatorDtoUtil;
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
public class BrandsServiceImpl implements BrandsService<UUID> {

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BrandsDTO addNewBrand(BrandsDTO brandsDTO){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<BrandsDTO>> violations = validator.validate(brandsDTO);

        if (!violations.isEmpty()){
            for (ConstraintViolation<BrandsDTO> violation : violations) {
                System.out.println("Ошибка валидации: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
            return null;
            }else {

            Brands brands = modelMapper.map(brandsDTO, Brands.class);
            return modelMapper.map(brandsRepository.save(brands), BrandsDTO.class);
        }

    }



    @Override
    public BrandsDTO getBrandById(int id) {
        return null;
    }

    @Override
    public BrandsDTO getBrandById(UUID id){
        Optional<Brands> brands = brandsRepository.findById(id);
        return brands.map(object -> modelMapper.map(object, BrandsDTO.class)).orElse(null);
    }

    @Override
    public List<BrandsDTO> getAllBrands(){
        List<Brands> brandsList = brandsRepository.findAll();
        return brandsList.stream().map(brands -> modelMapper.map(brands, BrandsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BrandsDTO updateBrand(int id, BrandsDTO brandsDTO) {
        return null;
    }

    @Override
    public BrandsDTO updateBrand(UUID id, BrandsDTO brandsDTO){
        Brands currentBrands = brandsRepository.findById(id).orElse(null);
        if (currentBrands != null){
            modelMapper.map(brandsDTO, currentBrands);
            return modelMapper.map(brandsRepository.save(currentBrands), BrandsDTO.class);
        }
        return  null;
    }

    @Override
    public void deleteBrands(int id) {

    }

    @Override
    public void deleteBrands(UUID id){
        brandsRepository.deleteById(id);
    }

}
