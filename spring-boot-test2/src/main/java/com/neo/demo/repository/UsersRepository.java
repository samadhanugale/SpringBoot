package com.neo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
