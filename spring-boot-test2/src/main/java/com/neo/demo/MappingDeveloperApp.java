package com.neo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neo.demo.model.Developer;
import com.neo.demo.model.Project;
import com.neo.demo.repository.DeveloperRepository;
import com.neo.demo.repository.ProjectRepository;

@SpringBootApplication
public class MappingDeveloperApp{} /*implements CommandLineRunner {

	@Autowired
	private DeveloperRepository developerRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(MappingDeveloperApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Developer developer = new Developer("Developer1", "Developer1@gmail.com");
//		
//		Project project = new Project("SpringProject", "10 Days");
//		Developer developer = new Developer("Developer2", "Developer2@gmail.com");
//
//		Project project = new Project("SpringCarProject", "12 Days");
//
//		developer.setProject(project);
//		project.setDeveloper(developer);
//
//		developerRepository.save(developer);
		
		
		 * Users user = usersRepository.findById((long)5).get();
		 * userProfile.setUsers(user); usersProfileRepository.save(userProfile);
		 
		
		developerRepository.deleteById((long) 2);
		
	
		
		

	}

}
*/