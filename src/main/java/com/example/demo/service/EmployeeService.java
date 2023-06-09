package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long employeeId);
    Employee updateEmployee(Employee employee,long employeeId);
    String deleteEmployee(long employeeId);

}
