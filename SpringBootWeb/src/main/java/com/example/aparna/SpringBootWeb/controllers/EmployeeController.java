package com.example.aparna.SpringBootWeb.controllers;

import com.example.aparna.SpringBootWeb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees") //Path for Parent
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage() {
//        return "Secret Message: Aparna";
//    }

    @GetMapping(path = "/{employeeId}") //children /employees/{employeeId}
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId, "Anaya", "anaya@gmail.com", 20, LocalDate.of(2026, 1, 2), true);
    }

    @GetMapping //children
    public String getEmployeeAge(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return "Hi age " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO addEmployeeData(@RequestBody EmployeeDTO inputEmployee ) {
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping String updateEmployeeId() {
        return "Hello from Employee";
    }
}
