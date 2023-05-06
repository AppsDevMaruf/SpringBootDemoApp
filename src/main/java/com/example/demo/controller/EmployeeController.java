package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //build create get All Employee Rest API
    @GetMapping
    private List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    //build create an Employee Rest API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    //build get Employee by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exit with id: " + id));
        return ResponseEntity.ok(employee);

    }

    //build update Employee Rest API
    @PutMapping("{id}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exit with id:" + id));

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmail(employee.getEmail());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }
    //build delete employee Rest API
    @DeleteMapping("{id}")
    private ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee deleteEmpId = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exit with id:" + id));
        employeeRepository.delete(deleteEmpId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
