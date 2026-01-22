package com.example.aparna.SpringBootWeb.controllers;

import com.example.aparna.SpringBootWeb.dto.EmployeeDTO;
import com.example.aparna.SpringBootWeb.entities.EmployeeEntity;
import com.example.aparna.SpringBootWeb.services.EmployeeService;
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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}") //children /employees/{employeeId}
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return employeeService.findEmployeeId(employeeId);
    }

    @GetMapping //children
    public List<EmployeeDTO> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeEntity inputEmployee ) {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping (path = "/{employeeId}")
    public EmployeeDTO updateEmployeeId(@RequestBody EmployeeDTO employeeDTO, @PathVariable long employeeId) {
        return employeeService.updateEmployeeId(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }
}
