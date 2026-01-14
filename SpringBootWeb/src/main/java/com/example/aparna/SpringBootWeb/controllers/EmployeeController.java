package com.example.aparna.SpringBootWeb.controllers;

import com.example.aparna.SpringBootWeb.dto.EmployeeDTO;
import com.example.aparna.SpringBootWeb.entities.EmployeeEntity;
import com.example.aparna.SpringBootWeb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees") //Path for Parent
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage() {
//        return "Secret Message: Aparna";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}") //children /employees/{employeeId}
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping //children
    public List<EmployeeEntity> getEmployeeAge(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity addEmployeeData(@RequestBody EmployeeEntity inputEmployee ) {

        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeId() {
        return "Hello from Employee";
    }
}
