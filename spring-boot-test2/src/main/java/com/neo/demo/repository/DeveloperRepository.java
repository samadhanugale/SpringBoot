package com.neo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
