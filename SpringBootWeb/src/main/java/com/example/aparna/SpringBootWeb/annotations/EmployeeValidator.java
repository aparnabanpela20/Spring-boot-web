package com.example.aparna.SpringBootWeb.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeValidator implements ConstraintValidator<EmployeeRoleAnnotation, String> {

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
    List<String> roles = List.of("USER", "ADMIN");
    return roles.contains(inputRole);
    }
}
