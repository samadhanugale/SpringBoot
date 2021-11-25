package com.neo.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	
	
	@NotNull
	@Size(max = 65)
	@Column(name = "project_name")
	private String projectName;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "duration")
	private String duration;
	
	
	@OneToOne(fetch = FetchType.LAZY) //lazy-data can be lazily fetch -> if required then create it else not
	@JoinColumn(name = "developer_id", nullable = false)
	private Developer developer;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(@NotNull @Size(max = 65) String projectName, @NotNull @Size(max = 65) String duration) {
		super();
		this.projectName = projectName;
		this.duration = duration;
	}


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Developer getDeveloper() {
		return developer;
	}


	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}	
}
