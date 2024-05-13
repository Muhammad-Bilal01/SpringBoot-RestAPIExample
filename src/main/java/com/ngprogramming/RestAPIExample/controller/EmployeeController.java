package com.ngprogramming.RestAPIExample.controller;

import com.ngprogramming.RestAPIExample.model.Employee;
import com.ngprogramming.RestAPIExample.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping("/api/emp") // for employee
public class EmployeeController {

//    Create instance of EmployeeRepository
    @Autowired
    private EmployeeRepository employeeRepository;

//    Get
    @GetMapping("/employees")
    public ResponseEntity<Object> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id){

        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findById(id));
    }


//    Post - Create -C
//    @RequestBody to convert json data into given model

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid Employee employee){
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created Successfully!");
    }

//    Put
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Integer id, @RequestBody Employee emp){
       Optional<Employee> employee =   employeeRepository.findById(id);
       if (employee.isPresent()){
            Employee existingEmp = employee.get();
            existingEmp.setName(emp.getName());
            existingEmp.setAge(emp.getAge());
            existingEmp.setRole(emp.getRole());
            existingEmp.setCity(emp.getCity());
           return ResponseEntity.status(HttpStatus.OK).body("Employee Updated with this "+ id);
       }else{
           throw new DataNotFoundException("DataNotFound " + "No Employee Found with this "+ id);
       }
    }


//    Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id){
        employeeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Successfully for "+ id);
    }

}
