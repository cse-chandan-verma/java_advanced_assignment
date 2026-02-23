package com.capgemini.onetomany.unidirectional;

import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee emp1 = new Employee("Chandan", "SDE1", 70000);
		Employee emp2= new Employee("Abhishek", "SDE2", 80000);
		Employee emp3 = new Employee("Milind", "SDE", 75000);
		
		Department department = new Department("Software Developer", "Punjab");
		
		department.setListOfEmployees(Arrays.asList(emp1, emp2, emp3));
		
		em.persist(department);
	
		em.getTransaction().commit();
		
	}
}
