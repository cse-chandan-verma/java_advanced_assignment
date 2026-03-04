package com.springrest.api.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String title;
	
	@Column(nullable = false, length = 120)
	private String author;
	
	@Column(nullable = false, length = 150)
	private String genre;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private LocalDate publishedDate;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long id, String title, String author, String genre, Double price, LocalDate publishedDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.publishedDate = publishedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	
}
