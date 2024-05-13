package com.ngprogramming.RestAPIExample.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Name must not be empty")
    @Size(min = 5,max = 30, message = "Role length in between 5 to 30")
    private String role;

    @NotBlank(message = "City must not be empty")
    private String city;

    @Min(value = 18,message = "Age must be in between 18 to 30")
    @Max(value = 30,message = "Age must be in between 18 to 30")
    private int age;


}
