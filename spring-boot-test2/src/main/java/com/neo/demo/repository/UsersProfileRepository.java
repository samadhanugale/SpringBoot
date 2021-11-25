package com.neo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.model.UsersProfile;

public interface UsersProfileRepository extends JpaRepository<UsersProfile, Long> {

}
