package com.capgemini.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

public class App {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manytomanyPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Project p1 = new Project();
		p1.setProjectName("Banking Management System");
		
		Project p2 = new Project();
		p2.setProjectName("E-Commerce Website");
	
		Set<Project> projectSet1 = new HashSet<>();
		projectSet1.add(p1);
		projectSet1.add(p2);
		
		Set<Project> projectSet2 = new HashSet<>();
		projectSet2.add(p2);
		
		em.persist(p1);
		em.persist(p2);
		
		Employee e1 = new Employee();
		e1.setName("Chandan");
		
		Employee e2 = new Employee();
		e2.setName("Abhishek");
		
		e1.setProjects(projectSet2);
		em.persist(e1);

		e2.setProjects(projectSet1);
		em.persist(e2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
