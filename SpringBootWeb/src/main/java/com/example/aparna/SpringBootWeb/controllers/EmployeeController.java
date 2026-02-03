package com.example.aparna.SpringBootWeb.controllers;

import com.example.aparna.SpringBootWeb.dto.EmployeeDTO;
import com.example.aparna.SpringBootWeb.entities.EmployeeEntity;
import com.example.aparna.SpringBootWeb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
        Optional<EmployeeDTO> employDTO =  employeeService.findEmployeeId(employeeId);

        return employDTO.
                map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).
                        orElse(ResponseEntity.notFound().build());
    }

    @GetMapping //children
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee ) {
        EmployeeDTO employeeDTO = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PutMapping (path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeId(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeId(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable long employeeId){
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping (path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@PathVariable long employeeId, @RequestBody Map<String, Object> updates){
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployee(employeeId, updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
