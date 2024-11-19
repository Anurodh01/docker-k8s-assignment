package com.spring.restdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.restdata.models.Employee;
import com.spring.restdata.repo.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeServiceApplication {
    @Autowired
    private EmployeeRepository repository;

    @PostConstruct
    public void initDB() {
        repository.saveAll(readJsonData());
    }

    private List<Employee> readJsonData() {
        List<Employee> employees;
        try {
            InputStream inputStream = new ClassPathResource("employees.json").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ObjectMapper objectMapper = new ObjectMapper();
            employees = Arrays.asList(objectMapper.readValue(reader, Employee[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }
}
