package com.neo.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.neo.demo.model.User;

@Service
@CacheConfig(cacheNames = "users") //Where to dstore cache or by which name
public class UserService {
	private List<User> users = new ArrayList<User>(Arrays.asList(
			new User(101,"Hannah","hannah123"),
			new User(102,"Jonas","jonas223"),
			new User(103,"adam","adam123"),
			new User(104,"peter","peter123")
			));
	public List<User> getAllUsers(){
		return users;
	}
	public User getUser(int id){
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	public void deleteUser(int id) {
		users.removeIf(u -> u.getId() == id);
	}
	public void updateUser(User user,int id) {
		users.replaceAll(u->{
			if(u.getId() == id) {
				u = user;
			}
			return u;
		});
	}
	//Sort By username
	public List<User> sortByUsername(){
		Comparator<User> byNameComparator = Comparator.comparing(User::getUsername);
		return users.stream().sorted(byNameComparator).collect(Collectors.toList());
	}
	
	public List<User> sortById(){
		Comparator<User> byIdComparator = Comparator.comparing(User::getId).reversed();
		return users.stream().sorted(byIdComparator).collect(Collectors.toList());
	}
	
	
	//Testing springBoot Cache
	@Cacheable
	public List<User> findAll(){
		slowService();
		return this.users;
	}
	private void slowService() {
		try {
			Thread.sleep(3000L);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
