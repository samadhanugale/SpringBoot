package com.neo.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.model.Comment;
import com.neo.demo.myException.ResourceNotFoundException;
import com.neo.demo.repository.CommentRepository;
import com.neo.demo.repository.PostRepository;

@RestController
public class CommentController {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping("/comments")
	public List<Comment> getAllComments(){
		return commentRepo.findAll();
	}
	
	@GetMapping("/posts/{postId/comments")
	public List<Comment> getAllCommentsByPostId(@PathVariable Long postId){
		return commentRepo.findByPostId(postId);
	}
	
	@GetMapping("/comments/{id}")
	public Optional<Comment> getCommentById(@PathVariable Long id) {
		return commentRepo.findById(id);
	}
	@GetMapping("/posts/{postId}/comments/{id}")
	public Comment getcommentByIdAndPostById(@PathVariable Long postId,@PathVariable Long id) {
		return commentRepo.findByIdAndPostId(postId,id);
	}
	
	@PostMapping("/posts/{postId}/comments")
	public Comment createComment(@PathVariable Long postId , @Valid @RequestBody Comment comment) {
		return postRepo.findById(postId).map(post ->{
			comment.setPost(post);
			return commentRepo.save(comment);
		}).orElseThrow(()->new ResourceNotFoundException("post","postId",postId));
	}
	
	@PutMapping("/comments/{id}")
	public Comment updateComment(@PathVariable Long id, @Valid @RequestBody Comment commentReq) {
		return commentRepo.findById(id).map(comment ->{
			comment.setText(comment.getText());
			return commentRepo.save(commentReq);
		}).orElseThrow(()-> new ResourceNotFoundException("comment","commentId",id));
	}
	
	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable Long id) {
		commentRepo.findById(id).map(comment->{
			commentRepo.delete(comment);
			return comment;
		}).orElseThrow(()-> new ResourceNotFoundException("comment","commentId",id));
	}
	
}
