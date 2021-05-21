package com.example.empmgmtservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.empmgmtservice.models.Employee;
import com.example.empmgmtservice.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
    @GetMapping(path="/")
	public String welcome() {
		return "Application is Up and Running";	
	}
    
	@GetMapping(path="/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = empService.getListOfAllEmployee();
		return employeeList;	
	}
	
	@GetMapping(path="/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		Employee emp = empService.getEmployee(id);
		return emp;
	}
	
}
