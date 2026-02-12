package com.capgemini.libraryBookInventryManagementSystem;

import jakarta.persistence.*;

import java.util.List;

public class LibraryBookJpaApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        Book b1 = new Book(1, "Java Fundamentals",
                "James Gosling", "Programming",
                550.0, "Available", 2015);

        Book b2 = new Book(2, "Hibernate Basics",
                "Gavin King", "Programming",
                650.0, "Available", 2018);

        Book b3 = new Book(3, "Database Concepts",
                "C.J. Date", "Database",
                700.0, "Issued", 2012);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);

        em.getTransaction().commit();

        Book book = em.find(Book.class, 1);
        System.out.println("Fetched by ID:");
        System.out.println(book);

        // Fetch all books
        System.out.println("\nAll Books:");
        List<Book> books =
                em.createQuery("from Book", Book.class).getResultList();

        for (Book b : books) {
            System.out.println(b);
        }

        em.getTransaction().begin();

        Book updateBook = em.find(Book.class, 2);
        updateBook.setPrice(800.0);
        updateBook.setAvailabilityStatus("Issued");

        em.getTransaction().commit();

        System.out.println("\nAfter Update:");
        System.out.println(em.find(Book.class, 2));

        em.getTransaction().begin();

        Book deleteBook = em.find(Book.class, 3);
        em.remove(deleteBook);

        em.getTransaction().commit();

        System.out.println("\nAfter Delete:");
        List<Book> updatedList =
                em.createQuery("from Book", Book.class).getResultList();

        for (Book b : updatedList) {
            System.out.println(b);
        }

        em.close();
        emf.close();
    }
}
