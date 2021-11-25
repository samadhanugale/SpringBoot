package com.neo.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.model.Post;
import com.neo.demo.myException.ResourceNotFoundException;
import com.neo.demo.repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postRepo.findAll();
	}
	
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody Post post) {
		return postRepo.save(post);
	}
	
	@PutMapping("/post/{postId}")
	public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postReq) {
		
		return postRepo.findById(postId).map(post -> {
			post.setTitle(postReq.getTitle());
			post.setDescription(postReq.getDescription());
			post.setContent(postReq.getContent());
			return postRepo.save(post);
		}).orElseThrow(()->new ResourceNotFoundException("post","postId",postId));
	}
	
	@DeleteMapping("/post/{postId}")
	public void deletePost(@PathVariable Long postId) {
		postRepo.findById(postId).map(post->{
			postRepo.delete(post);
			return post;
		}).orElseThrow(()->new ResourceNotFoundException("post","postId",postId));
	}
}
