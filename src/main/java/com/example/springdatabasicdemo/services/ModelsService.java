package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.enumPacage.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ModelsService<ID>{
    ModelsDTO addNewModels(ModelsDTO modelsDTO, MultipartFile file);

    ModelsDTO addModels(ModelsDTO modelsDTO);

    ModelsDTO geModelById(int id);

    ModelsDTO geModelById(UUID id);

    List<ModelsDTO> getAllModels();

    List<ModelsDTO> getTopThreeModels();

    ModelsDTO getModelByThreeParam(String name, int startYear, int endYear);

    ModelsDTO updateModels(int id, ModelsDTO modelsDTO);

    ModelsDTO updateModels(UUID id, ModelsDTO modelsDTO);

    ModelsDTO updateModelsByName(String name, ModelsDTO modelsDTO);

    void deleteModels(int id);

    void deleteModels(UUID id);
    @Modifying
    @Transactional
    void deleteThreeParam(String name, int startYear, int endYear);

    void  deleteModelsByname(String name);

    List<ModelsDTO> findModelsByBrands (BrandsDTO brandsDTO);

    List<ModelsDTO> findModelsByCategory(Category category);
}
