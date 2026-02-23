package com.capgemini.hibernate.manytomany;
	
import java.util.Set;
	
import jakarta.persistence.*;
	
@Entity
	
public class Project {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> emplyee_project;

	public Project() {
		super();
	}
	
	public Project(String projectName, Set<Employee> emplyee_project) {
		super();
		this.projectName = projectName;
		this.emplyee_project = emplyee_project;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Set<Employee> getEmplyee_project() {
		return emplyee_project;
	}
	
	public void setEmplyee_project(Set<Employee> emplyee_project) {
		this.emplyee_project = emplyee_project;
	}
}
