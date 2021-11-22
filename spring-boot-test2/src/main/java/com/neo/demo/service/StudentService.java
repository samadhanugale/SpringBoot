package com.neo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neo.demo.model.Student;
import com.neo.demo.repository.StudentRepository;

@Service
@CacheConfig(cacheNames = "students")
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Cacheable
	public List <Student> getAllStudents(){
//		try {
//			Thread.sleep(3000L);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		return studentRepo.findAll();
	}
	
	public Optional<Student> getStudent(long id) {
		return studentRepo.findById(id);
	}
	
	public void addStudent(Student employee) {
		studentRepo.save(employee);
	}
	
	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}
	
	public void updateStudent(Student student,long id) {
		studentRepo.findById(id);
			studentRepo.save(student);
		
	}
	


}
