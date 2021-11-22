package com.neo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.model.Employee;
import com.neo.demo.model.User;
import com.neo.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	//To display log contents like custom message, warning
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeService employeeService;
	
	

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		logger.info("Get employee Logger Method :: "+new java.util.Date().toString());
		return employeeService.getEmployees();
	}

	@GetMapping("employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id) {
		return employeeService.getEmployee(id);
	}

	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping("employee/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		employee.setId(id);
		employeeService.updateEmployee(employee, id);
	}
	// --------------Response Entity----------------------

	@PostMapping("/employees/response")
	public ResponseEntity<Employee> addEmployeeResponse(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@GetMapping("employee/response/{id}")
	public ResponseEntity<Object> getEmployeeResponse(@PathVariable long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if (employee.isPresent()) {
			return new ResponseEntity<Object>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("No such ID : " + id, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader() {
		return ResponseEntity.ok().header("CustomHeader", "NEO").body("Custom header set as NEO");
	}

	@GetMapping("/employees/response")
	public ResponseEntity<Object> getEmployeesResponse() {
		List<Employee> employee = employeeService.getEmployees();
		if (employee.isEmpty())
			return new ResponseEntity<Object>("Empty List ", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/employee/response/{id}")
	public ResponseEntity<Object> deleteEmployeeResponse(@PathVariable long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if (employee.isPresent()) {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<Object>("Employee Deleted ", HttpStatus.GONE);
		}
		else
			return new ResponseEntity<Object>("Employee Not found!  ", HttpStatus.NOT_FOUND);
	}

	@PutMapping("employee/response/{id}")
	public ResponseEntity<Object> updateEmployeeResponse(@RequestBody Employee employee, @PathVariable long id) {
		employee.setId(id);
		employeeService.updateEmployee(employee, id);
		return new ResponseEntity<Object>("Employee Updated", HttpStatus.OK);
	}
	
	//---------------LoggerTest------------------
	@GetMapping("/logger")
	public String getLogger() {
		logger.info("/Logger Method :: "+new java.util.Date().toString());
		logger.warn("/Logger Method :: "+new java.util.Date().toString());
		logger.error("/Logger Method :: "+new java.util.Date().toString());
		return "Logger test";
	}
}
