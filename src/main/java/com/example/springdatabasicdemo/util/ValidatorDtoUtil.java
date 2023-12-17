package com.example.springdatabasicdemo.util;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidatorDtoUtil {
//    <E> boolean isValid(E object);

//    <E> Set<ConstraintViolation<E>> violations(E object);

    <E> Set<ConstraintViolation<E>> validate(E object);

    boolean isValid(String value, ConstraintValidatorContext context);
}
