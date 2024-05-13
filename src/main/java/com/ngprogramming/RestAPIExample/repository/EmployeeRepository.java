package com.ngprogramming.RestAPIExample.repository;

import com.ngprogramming.RestAPIExample.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
