package com.example.aparna.SpringBootWeb.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name of the employee cannot be blank")
    @Size(min = 3, max = 10)
    private String name;

    @Email(message = "Email should be a valid Email")
    private String email;

    @Positive
    @Max(value = 60, message = "Age cannot be greater than 60")
    @Min(value = 18, message = "Age should be greater than 18")
    private Integer age;

    @NotBlank(message = "Role of Employee can not be blank")
    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee ca be a USER or ADMIN") //regular expression, has a proper format.
    private String role; //ADMIN, USER

    @PastOrPresent
    private LocalDate dateOFJoining;

    @AssertTrue
    private Boolean isActive;

}
