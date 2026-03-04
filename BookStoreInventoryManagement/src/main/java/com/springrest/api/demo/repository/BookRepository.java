package com.springrest.api.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.api.demo.model.Book;


public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByAuthor(String author);
	Page<Book> findByGenre(String genre, Pageable pageable);
	List<Book> findByPriceLessThan(Double price);
	List<Book> findByPriceGreaterThan(Double price);
	List<Book> findByPublishedDateAfter(LocalDate date);
	List<Book> findByPublishedDateBefore(LocalDate date);
	List<Book> findByTitleContaining(String keyword); 
	List<Book> findByTitleStartingWith(String prefix);
	List<Book> findByTitleEndingWith(String suffix);
	List<Book> findByGenreAndAuthor(String genre, String author);
	List<Book> findByGenreOrAuthor(String genre, String author);
	List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
	List<Book> findByGenreAndPriceLessThan(String genre, Double price);
	Page<Book> findByOrderByPublishedDateDesc(Pageable pageable);
	Page<Book> findByOrderByPriceAsc(Pageable pageable); 
}
