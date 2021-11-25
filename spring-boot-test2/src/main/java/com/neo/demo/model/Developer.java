package com.neo.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "developer")
public class Developer {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long devId;
	
	
	@NotNull
	@Size(max = 65)
	@Column(name = "Developer_name")
	private String devName;
	
	
	@NotNull
	@Size(max = 120)
	@Column(unique = true)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "developer")//cascade->if user is deleted then user profile also be deleted
	private Project project;

	public Developer() {
		// TODO Auto-generated constructor stub
	}
	
	public Developer(@NotNull @Size(max = 65) String devName, @NotNull @Size(max = 120) String email) {
		super();
		this.devName = devName;
		this.email = email;
	}

	public long getDevId() {
		return devId;
	}

	public void setDevId(long devId) {
		this.devId = devId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
