package com.neo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data //Getter setters, Constructors auto created
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
	
	@NotNull
	@Size(max =100)
	private String title;
	
	@NotNull
	@Size(max =100)
	private String description;
	
	@NotNull
	@Lob //Large object
	private String content;

}
