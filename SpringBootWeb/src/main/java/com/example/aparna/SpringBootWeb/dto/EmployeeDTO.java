package com.example.aparna.SpringBootWeb.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOFJoining;
    private Boolean isActive;

    public EmployeeDTO (){

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOFJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOFJoining = dateOFJoining;
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getDateOFJoining() {
        return dateOFJoining;
    }

    public void setDateOFJoining(LocalDate dateOFJoining) {
        this.dateOFJoining = dateOFJoining;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
