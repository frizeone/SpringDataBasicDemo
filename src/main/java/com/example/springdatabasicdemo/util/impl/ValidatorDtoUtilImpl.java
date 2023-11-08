package com.example.springdatabasicdemo.util.impl;

import com.example.springdatabasicdemo.util.ValidatorDtoUtil;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

@Component
public class ValidatorDtoUtilImpl implements ValidatorDtoUtil {

//    private final Validator validator;

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Autowired
    public ValidatorDtoUtilImpl(Validator validator) {
        this.validator = validator;
    }

//    @Override
//    public <E> boolean isValid(E object) {
//        return this.validator.validate(object).size() == 0;
//    }



//    @Override
//    public <E> Set<ConstraintViolation<E>> violations(E object) {
//        return null;
//    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate(E object) {
        return this.validator.validate(object);
    }

//    public <E> boolean isValid(T object){return this.validator.validate(object).size() == 0; }


//    @Override
//    public <T> Set<ConstraintViolation<T>> validate(T dto) {
//        return this.validator.validate(dto);
//    }





}
