package com.devskiller.tasks.blog.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;
	@Column(name = "proj_name")
	private String projectName;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="proj_user",joinColumns = {@JoinColumn(name="ID")},inverseJoinColumns = {@JoinColumn(name = "Emp_ID")})
	private List<User> users;

	public String getProjectName() {
		return projectName;
	}
	public void addNewUser(User theUser)
	{
		if(users==null)
			users=new ArrayList<>();
		users.add(theUser);
		theUser.getProjects().add(this);
	}

	public Long getId() {
		return Id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
