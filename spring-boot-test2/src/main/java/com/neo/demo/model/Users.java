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
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	@Size(max = 65)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Size(max = 120)
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Size(max = 15)
	@Column(unique = true)
	private String password;	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "users")//cascade->if user is deleted then user profile also be deleted
	private UsersProfile usersProfile;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(@NotNull @Size(max = 65) String firstName, @NotNull @Size(max = 65) String lastName,
			@NotNull @Size(max = 120) String email, @NotNull @Size(max = 15) String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsersProfile getUsersProfile() {
		return usersProfile;
	}

	public void setUsersProfile(UsersProfile usersProfile) {
		this.usersProfile = usersProfile;
	}

}
