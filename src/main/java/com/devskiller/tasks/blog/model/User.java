package com.devskiller.tasks.blog.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userlogin")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "token")
	private String token;
	@Column(name = "notes")
	private String notes;
	@ManyToMany(mappedBy = "users")
	private List<Project> projects;

	public String getUserName() {
		return userName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}

	public String getNotes() {
		return notes;
	}

	public void setToken(String token) {
		this.token = token;
	}
    public User()
	{

	}
	public User(String usrname,String password)
	{
     this.userName=usrname;
	 this.password=password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
