package com.neo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
