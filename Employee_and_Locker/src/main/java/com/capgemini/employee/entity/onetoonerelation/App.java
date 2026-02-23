package com.capgemini.employee.entity.onetoonerelation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Locker locker = new Locker(1, "LOCKER - 1", 2);
		Employee employee = new Employee(101, "Chandan", "SDE");
		
		employee.setLocker(locker);
		
		em.persist(locker);
		em.persist(employee);
		
		em.getTransaction().commit();
		
		
	}
}
