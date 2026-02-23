package com.capgemini.onetoone.relation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		//Step 1: Create EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		
		//Step 2: Create EntityMnanger
		EntityManager em = emf.createEntityManager();
		
		//Step 3: Begin Transaction
		em.getTransaction().begin();
		
		//Step 4: Create Objects
		Account account = new Account("ACC12345", "Savings");
		Customer customer = new Customer("John Dae", account);
		
		//Set bidirectional relationship
		account.setCustomer(customer);
		em.persist(customer);
		
		//Step 5: Persist
		em.getTransaction().commit();
		System.out.println("Customer and Account saved successfully!");
		
		
	}
}
