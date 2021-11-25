package com.neo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
