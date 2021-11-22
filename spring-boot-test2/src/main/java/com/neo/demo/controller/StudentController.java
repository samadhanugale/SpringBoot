package com.neo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.model.Student;
import com.neo.demo.service.StudentService;

@RestController
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		logger.info("Student added at :: "+new java.util.Date().toString());
		studentService.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}

	@GetMapping("/searchstudent/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable long id) {
		Optional<Student> student = studentService.getStudent(id);
		if (student.isPresent()) {
			logger.info("Found student at :: "+new java.util.Date().toString());
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		} else {
			logger.warn("Student not found :: "+new java.util.Date().toString());
			return new ResponseEntity<Object>("No such ID : " + id, HttpStatus.NOT_FOUND);
		}

	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/allstudents")
	//@GetMapping("/allstudents")
	public ResponseEntity<Object> getStudents() {
		List<Student> student = studentService.getAllStudents();
		if (student.isEmpty()) {
			logger.warn("Student not found :: "+new java.util.Date().toString());
			return new ResponseEntity<Object>("Empty List ", HttpStatus.NOT_FOUND);
		}
		else {
			logger.info("Students found at :: "+new java.util.Date().toString());
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		}
	}

	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Object> deleteEmployeeResponse(@PathVariable long id) {
		Optional<Student> student = studentService.getStudent(id);
		if (student.isPresent()) {
			
			studentService.deleteStudent(id);
			logger.info("Student deleted :: "+new java.util.Date().toString());
			return new ResponseEntity<Object>("Student Deleted ", HttpStatus.GONE);
		}
		else {
			logger.error("Student not found :: "+new java.util.Date().toString());
			return new ResponseEntity<Object>("Student Not found!  ", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("updatestudent/{id}")
	public ResponseEntity<Object> updateEmployeeResponse(@RequestBody Student student, @PathVariable long id) {
		student.setStid(id);
		studentService.updateStudent(student, id);
		logger.info("Student updated at :: "+new java.util.Date().toString());
		return new ResponseEntity<Object>("Student Updated", HttpStatus.OK);
	}
	@GetMapping("/al")
	public List<Student> getAllUsers(){
		return studentService.getAllStudents();
	}
}
