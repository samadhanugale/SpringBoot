package com.neo.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Lob
	private String text;
	
	
	@ManyToOne//(fetch = FetchType.LAZY) //to be deleted automatically after deleting related data from another table	 
	@JoinColumn(name = "post_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Post post;

}
