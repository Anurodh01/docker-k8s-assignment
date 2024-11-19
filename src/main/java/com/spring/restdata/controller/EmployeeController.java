package com.spring.restdata.controller;

import com.spring.restdata.models.Employee;
import com.spring.restdata.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    @GetMapping("/{employeeId}")
    public Employee getEmployees(@PathVariable String employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }
}
