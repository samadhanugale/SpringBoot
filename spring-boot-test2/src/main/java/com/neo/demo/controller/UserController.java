package com.neo.demo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.model.User;
import com.neo.demo.service.CompareByName;
import com.neo.demo.service.UserService;

@RestController
public class UserController {
	Comparator<User> compare = null;

	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable int id) {
		 userService.deleteUser(id);
	}
	
	@PutMapping("/user/{id}")
	public void updateUser ( @RequestBody User user,@PathVariable int id) {
		userService.updateUser(user, id);
	}
	
	@GetMapping("users/sortByName")
	public List<User> getUsersSortedByName(){
		return userService.sortByUsername();
	}
	@GetMapping("users/sortById")
	public List<User> getUsersSortedById(){
		return userService.sortById();
	}
	
	//Testing springBoot Cache
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
}
