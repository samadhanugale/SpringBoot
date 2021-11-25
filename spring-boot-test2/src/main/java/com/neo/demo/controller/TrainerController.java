package com.neo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.neo.demo.model.Trainer;
import com.neo.demo.myException.ResourceNotFoundException;
import com.neo.demo.repository.TrainerRepository;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	
	@Autowired
	private TrainerRepository trainerRepo;
	
	@GetMapping
	public List<Trainer> getAllTrainers(){
		return trainerRepo.findAll();
	}
	
	@PostMapping("/add")
	public void addTrainer(@RequestBody Trainer trainer) {
		trainerRepo.save(trainer);
	}
	
	@GetMapping("/and/{firstname}/{lastname}")
	public Trainer getTrainerByFnameAndLname(@PathVariable String firstname,@PathVariable String lastname) {
		return trainerRepo.findByFirstnameAndLastname(firstname, lastname);
	}
	@GetMapping("/or/{firstname}/{lastname}")
	public Trainer getTrainerByFnamOrLname(@PathVariable String firstname,@PathVariable String lastname) {
		return trainerRepo.findByFirstnameAndLastname(firstname, lastname);
	}
	@GetMapping("/agelessthan/{a}")
	public List<Trainer> getTrainerByAgeLessThan(@PathVariable int a) {
		return trainerRepo.findByAgeLessThan(a);
	}
	@GetMapping("/agelessthanequal/{a}")
	public List<Trainer> getTrainerByAgeLessThanEqual(@PathVariable int a) {
		return trainerRepo.findByAgeLessThanEqual(a);
	}
	@GetMapping("/agebetween/{a}/{b}")
	public List<Trainer> getTrainerByAgeBetween(@PathVariable int a,@PathVariable int b) {
		return trainerRepo.findByAgeBetween(a,b);
	}
	@GetMapping("/agelastorder/{a}")
	public List<Trainer> getTrainerByAgeOrderByLname(@PathVariable int a) {
		return trainerRepo.findByAgeOrderByLastnameDesc(a);
	}
	@GetMapping("/like/{firstname}")
	public List<Trainer> getTrainerByLike(@PathVariable String firstname) {
		return trainerRepo.findByFirstnameLike(firstname);
	}
	
	@GetMapping("/active/{a}")
	public List<Trainer> getAllActive(@PathVariable int a) {
		return trainerRepo.findAllActiveTrainers(a);
	}
	
	@GetMapping("/active/{active}/{age}")
	public List<Trainer> getAllActiveWithAge(@PathVariable int active,@PathVariable int age) {
		return trainerRepo.findAllActiveTrainersWithAge(active,age);
	}
	
	@PutMapping("/active/{active}/{name}")
	public int UpdateWithActiveName(@PathVariable int active,@PathVariable String name) {
		return trainerRepo.updateTrainerSetStatusForName(active,name);
	}
	
	//-------------------------------------------------------------------------
	@GetMapping("/{id}")
	public EntityModel<Trainer> getTrainerById(@PathVariable long id) {
		Optional<Trainer> trainer = trainerRepo.findById(id);
		if(!trainer.isPresent()) {
			throw new ResourceNotFoundException("Trainer", "Trainer id", id);
		}
		
		EntityModel<Trainer> resourse = EntityModel.of(trainer.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTrainers());
		resourse.add(linkTo.withRel("All-Trainers"));
		return resourse;
	}
	
	
}
