package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandsDTO;
import com.example.springdatabasicdemo.dtos.ModelsDTO;
import com.example.springdatabasicdemo.enumPacage.Category;
import com.example.springdatabasicdemo.models.Brands;
import com.example.springdatabasicdemo.models.Models;
import com.example.springdatabasicdemo.repositories.ModelsRepository;
import com.example.springdatabasicdemo.services.ModelsService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ModelsServiceImpl implements ModelsService<UUID> {

    @Autowired
    private ModelsRepository modelsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${upload.dir}")
    private String uploadDir;

    public ModelsDTO addNewModels(ModelsDTO modelsDTO, MultipartFile file) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ModelsDTO>> violations = validator.validate(modelsDTO);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<ModelsDTO> violation : violations) {
                System.out.println("Ошибка валидации: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
            return null;
        } else {
            try {
                // Сохранение файла в директорию
                String fileName = saveFile(file);

                // Обновление модели с учетом ссылки на файл
                modelsDTO.setImageUrl("/img/" + fileName);

                Models models = modelMapper.map(modelsDTO, Models.class);
                return modelMapper.map(modelsRepository.save(models), ModelsDTO.class);
            } catch (IOException e) {
                // Обработка ошибки сохранения файла
                e.printStackTrace();
                return null;
            }
        }
    }

    // ...

    private String saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path filePath = Path.of(uploadDir, fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    @Override
    public ModelsDTO addModels(ModelsDTO modelsDTO){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ModelsDTO>> violations = validator.validate(modelsDTO);

        if (!violations.isEmpty()){
            for (ConstraintViolation<ModelsDTO> violation : violations) {
                System.out.println("Ошибка валидации: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
            return null;
        }else {
            Models models = modelMapper.map(modelsDTO, Models.class);
            return modelMapper.map(modelsRepository.save(models), ModelsDTO.class);
        }
    }


    @Override
    public ModelsDTO geModelById(int id) {
        return null;
    }

    @Override
    public ModelsDTO geModelById(UUID id){
        Optional<Models> models = modelsRepository.findById(id);
        return models.map(object -> modelMapper.map(object, ModelsDTO.class)).orElse(null);
    }




    @Override
    public List<ModelsDTO> getAllModels(){
        List<Models> modelsList = modelsRepository.findAll();
        return modelsList.stream().map(models -> modelMapper.map(models, ModelsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ModelsDTO> getTopThreeModels(){
        List<Models> topThreeModelsList = modelsRepository.findTopThree();
        return topThreeModelsList.stream().map(models -> modelMapper.map(models, ModelsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ModelsDTO getModelByThreeParam(String name, int startYear, int endYear){
        Optional<Models> model = Optional.ofNullable(modelsRepository.findModelsByNameAndStartYearAndEndYear(name, startYear, endYear));
        return model.map(object -> modelMapper.map(object, ModelsDTO.class)).orElse(null);
    }

    @Override
    public ModelsDTO updateModels(int id, ModelsDTO modelsDTO) {
        return null;
    }

    @Override
    public ModelsDTO updateModels(UUID id, ModelsDTO modelsDTO){
        Models currentModels = modelsRepository.findById(id).orElse(null);
        if (currentModels != null){
            modelMapper.map(modelsDTO, currentModels);
            return modelMapper.map(modelsRepository.save(currentModels), ModelsDTO.class);
        }else{
            return null;
        }
    }


    @Override
    public ModelsDTO updateModelsByName(String name, ModelsDTO modelsDTO){
        Models currentModels = modelsRepository.findByName(name);
        if (currentModels != null){
            modelMapper.map(modelsDTO, currentModels);
            return  modelMapper.map(modelsRepository.save(currentModels), ModelsDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public void deleteModels(int id) {

    }

    @Override
    public void deleteModels(UUID id){
        modelsRepository.deleteById(id);
    }

    @Override
    public void deleteThreeParam(String name, int startYear, int endYear){
        modelsRepository.deleteModelsByNameAndStartYearAndEndYear(name, startYear, endYear);
    }

    @Override
    public void  deleteModelsByname(String name) {
        modelsRepository.deleteByName(name);
    }

    @Override
    public List<ModelsDTO> findModelsByBrands(BrandsDTO brandsDTO){
        Brands brands = modelMapper.map(brandsDTO, Brands.class);
        List<Models> models = modelsRepository.findByBrands(brands);
        List<ModelsDTO> modelDTOs = models.stream()
                .map(model -> modelMapper.map(model, ModelsDTO.class))
                .collect(Collectors.toList());
        return modelDTOs;

    }

    @Override
    public List<ModelsDTO> findModelsByCategory(Category category){
        List<Models> models = modelsRepository.findByCategory(category);
        return models.stream()
                .map(model -> modelMapper.map(model, ModelsDTO.class))
                .collect(Collectors.toList());
    }



}
