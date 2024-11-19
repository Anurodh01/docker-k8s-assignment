package com.spring.restdata.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@ToString
@Entity
@Builder
@AllArgsConstructor
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String employeeId;
    private String employeeName;
    private Double salary;
    private Integer age;
    private String designation;
}
