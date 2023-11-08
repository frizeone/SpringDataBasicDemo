package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.OffersDTO;
import com.example.springdatabasicdemo.dtos.RolesDTO;
import com.example.springdatabasicdemo.enumPacage.Role;
import com.example.springdatabasicdemo.models.Roles;
import com.example.springdatabasicdemo.repositories.RolseRepository;
import com.example.springdatabasicdemo.services.RolesService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService<UUID> {
    @Autowired
    private RolseRepository rolseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RolesDTO convertToDto(Roles roles) {
        return modelMapper.map(roles, RolesDTO.class);
    }

    public Roles convertToEntity(RolesDTO rolesDTO) {
        return modelMapper.map(rolesDTO, Roles.class);
    }

    @Override
    public RolesDTO createdRoles(RolesDTO rolesDTO){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<RolesDTO>> violations = validator.validate(rolesDTO);

        if (!violations.isEmpty()){
            for (ConstraintViolation<RolesDTO> violation : violations) {
                System.out.println("Ошибка валидации: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
            return null;
        }else {

            Roles roles = modelMapper.map(rolesDTO, Roles.class);
            roles = rolseRepository.save(roles);
            return modelMapper.map(roles, RolesDTO.class);
        }
    }

    @Override
    public RolesDTO getRoleById(int id) {
        return null;
    }

    @Override
    public RolesDTO getRoleById(UUID id){
        Optional<Roles> rolesOptional = rolseRepository.findById(id);
        return rolesOptional.map(roles -> modelMapper.map(roles, RolesDTO.class)).orElse(null);


    }

    @Override
    public List<RolesDTO> getAllRoles() {
        List<Roles> listRoles = rolseRepository.findAll();
        return listRoles.stream().map(roles -> modelMapper.map(roles, RolesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RolesDTO updateRoles(int id, RolesDTO rolesDTO) {
        return null;
    }


    @Override
    public RolesDTO updateRoles(UUID id, RolesDTO rolesDTO){
        Roles updateRoles = rolseRepository.findById(id).orElse(null);
        if (updateRoles == null){
            return null;
        }

        modelMapper.map(rolesDTO, updateRoles);
        updateRoles = rolseRepository.save(updateRoles);
        return modelMapper.map(updateRoles, RolesDTO.class);
    }

    @Override
    public void deleteRoleById(int id) {

    }


    @Override
    public void deleteRoleById(UUID id){
        rolseRepository.deleteById(id);
    }




}
