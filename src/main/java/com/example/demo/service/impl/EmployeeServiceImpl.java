package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", employeeId));
    }

    @Override
    public Employee updateEmployee(Employee employee, long employeeId) {
        //we check employee is existed or not
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", employeeId));
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        //save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public String deleteEmployee(long employeeId) {
        //we check employee is existed or not
        try {
            Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() ->
                    new ResourceNotFoundException("Employee", "Id", employeeId));
            employeeRepository.deleteById(existingEmployee.getId());

        }catch (Exception e){
            return "Failed reason: "+e;
        }
        return "Failed";
    }


}
