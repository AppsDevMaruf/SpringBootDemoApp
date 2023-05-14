package com.example.demo.controller;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //build create get All Employee Rest API
    @GetMapping("list")
    private List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    //build create an Employee Rest API
    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    //build get Employee by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);

    }

    //build update Employee Rest API
    @PutMapping("update/{id}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);

    }

    //build delete employee Rest API
    @DeleteMapping("{id}")
    private String deleteEmployee(@PathVariable("id") long employeeId) {

        employeeService.deleteEmployee(employeeId);
        return "";
    }
}
