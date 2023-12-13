package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.enumPacage.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface ModelsService<ID>{
    ModelsDTO addNewModels(ModelsDTO modelsDTO, MultipartFile file);

    ModelsDTO addModels(ModelsDTO modelsDTO);

    ModelsDTO geModelById(int id);

    ModelsDTO geModelById(UUID id);

    List<ModelsDTO> getAllModels();

    ModelsDTO updateModels(int id, ModelsDTO modelsDTO);

    ModelsDTO updateModels(UUID id, ModelsDTO modelsDTO);

    ModelsDTO updateModelsByName(String name, ModelsDTO modelsDTO);

    void deleteModels(int id);

    void deleteModels(UUID id);

    void  deleteModelsByname(String name);

    List<ModelsDTO> findModelsByBrands (BrandsDTO brandsDTO);

    List<ModelsDTO> findModelsByCategory(Category category);
}
