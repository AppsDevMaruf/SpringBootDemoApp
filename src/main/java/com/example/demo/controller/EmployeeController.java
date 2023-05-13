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
        return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }

    //build get Employee by id Rest API
  /*  @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exit with id: " + id));
        return ResponseEntity.ok(employee);

    }*/

    //build update Employee Rest API
   /* @PutMapping("update")
    private ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeRepository.findById(employee.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exit with id:" + employee.getId()));

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmail(employee.getEmail());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }*/
    //build delete employee Rest API
    /*@DeleteMapping("{id}")
    private ResponseEntity<String> deleteEmployee(@PathVariable long id){
        Employee deleteEmpId = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exit with id:" + id));
        employeeRepository.delete(deleteEmpId);
        return ResponseEntity.ok("delete Successfully");
    }*/

}
