package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.RolesDTO;
import com.example.springdatabasicdemo.dtos.UserDTO;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<UUID> {
   @Autowired
   private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO newUser(UserDTO userDTO){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        if (!violations.isEmpty()){
            for (ConstraintViolation<UserDTO> violation : violations) {
                System.out.println("Ошибка валидации: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
            return null;
        }else {

            Users users = modelMapper.map(userDTO, Users.class);
            System.out.println("Роли для нового пользователя: " + users.getRoles());
            return modelMapper.map(userRepository.save(users), UserDTO.class);
        }
    }

    @Override
    public UserDTO getUserById(int id) {
        return null;
    }

    @Override
    public UserDTO getUserById(UUID id){
        Optional<Users> user = userRepository.findById(id);
        return user.map(object -> modelMapper.map(object, UserDTO.class)).orElse(null);
    }


    @Override
    public UserDTO getUserByName(String first_name){
        Optional<User> users = userRepository.findByFirst_name(first_name);
        return users.map(object -> modelMapper.map(object, UserDTO.class)).orElse(null);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<Users> usersList = userRepository.findAll();
        return usersList.stream().map(users -> modelMapper.map(users, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUsers(int id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUsers(UUID id, UserDTO userDTO){
        Users currentUsers = userRepository.findById(id).orElse(null);
        if (currentUsers != null){
            modelMapper.map(userDTO, currentUsers);
            return modelMapper.map(userRepository.save(currentUsers), UserDTO.class);
        }else {
            return null;
        }

    }

    @Override
    public UserDTO apdateUsersByName(String first_name, String last_Name, UserDTO userDTO){
        Users currentUsers = userRepository.findByFirst_nameAndLast_name(first_name, last_Name);
        if (currentUsers != null){
            modelMapper.map(userDTO, currentUsers);
            return modelMapper.map(userRepository.save(currentUsers), UserDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public void deleteUsers(int id) {

    }

    @Override
    public void deleteUsers(UUID id){
        userRepository.deleteById(id);
    }
    @Override
    public void deleteUsersBuNameAndSeconName(String first_name, String last_name){
        userRepository.deleteByFirst_nameAndLast_name(first_name, last_name);
    }

}
