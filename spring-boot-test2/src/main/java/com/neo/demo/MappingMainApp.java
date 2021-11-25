package com.neo.demo;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neo.demo.model.Gender;
import com.neo.demo.model.Users;
import com.neo.demo.model.UsersProfile;
import com.neo.demo.repository.UsersRepository;

@SpringBootApplication
public class MappingMainApp {}/*implements CommandLineRunner {
	
	
	@Autowired
	private UsersRepository usersRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MappingMainApp.class, args); //Running appplication
	}

	@Override
	public void run(String... args) throws Exception {
		//Create user instance
		Users user = new Users("adam", "eva", "adamEva@mail.com","adam123");
		
		Calendar dob  = Calendar.getInstance();
		dob.set(1971,1,21);
		
		UsersProfile usersProfile = new UsersProfile("+91-9552505659",Gender.MALE, dob.getTime(), "Kanchan Grapes", "Nashik", "Maharashtra","India","422209");
		
		//set child referencein in parent entity
		user.setUsersProfile(usersProfile);
		
		//set parent referance in child entity
		usersProfile.setUsers(user);
		
		//save parent referance also will save child ref as well
		usersRepository.save(user);
	
	}
}
*/