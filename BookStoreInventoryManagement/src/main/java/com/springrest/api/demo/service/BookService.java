package com.springrest.api.demo.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springrest.api.demo.exception.ResourceNotFoundException;
import com.springrest.api.demo.model.Book;
import com.springrest.api.demo.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = bookRepository.findAll();
		if(books.isEmpty()) {
			throw new ResourceNotFoundException("No book found");
		}
		return books;
	}

	public List<Book> getBooksByAuthor(String author) {
		List<Book> books = bookRepository.findByAuthor(author);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for author: " + author);
		}
		return books;
	}

	public Page<Book> getBooksByGenre(String genre, Pageable pageable) {
		Page<Book> books = bookRepository.findByGenre(genre, pageable);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for genre: " + genre);
		}
		return books;
	}

	public List<Book> getBooksCheaperThan(Double price) {
		List<Book> books = bookRepository.findByPriceLessThan(price);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for price less than: " + price);
		}
		return books;
	}

	public List<Book> getBooksHigherPrice(Double price) {
		List<Book> books = bookRepository.findByPriceGreaterThan(price);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for price greater than: " + price);
		}
		return books;
	}

	public List<Book> getBooksPublishedAfter(LocalDate date) {
		List<Book> books = bookRepository.findByPublishedDateAfter(date);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found published after: " + date);
		}
		return books;
	}

	public List<Book> searchByTitleKeyword(String keyword) {
		List<Book> books = bookRepository.findByTitleContaining(keyword);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException(keyword);
		}
		return books;
	}

	public List<Book> getBooksByGenreAndAuthor(String genre, String author) {
		List<Book> books = bookRepository.findByGenreAndAuthor(genre, author);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for genre: " + genre + " and author: " + author);
		}
		return books;
	}

	public List<Book> getBooksByGenreOrAuthor(String genre, String author) {
		List<Book> books = bookRepository.findByGenreOrAuthor(genre, author);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for genre: " + genre + " Or author: " + author);
		}
		return books;
	}

	public List<Book> getBooksPriceInRange(Double minPrice, Double maxPrice) {
		List<Book> books = bookRepository.findByPriceBetween(minPrice, maxPrice);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No books found for price in between " + minPrice + " and " + maxPrice);
		}
		return books;
	}

	public List<Book> getBooksByGenreAndBelowPrice(String genre, Double price) {
		List<Book> books = bookRepository.findByGenreAndPriceLessThan(genre, price);
		if (books.isEmpty()) {
			throw new ResourceNotFoundException("No book found for genre " + genre + " with price less than " + price);
		}
		return books;
	}

	public Page<Book> getBooksInDes(Pageable pageable) {
		Page<Book> page = bookRepository.findByOrderByPublishedDateDesc(pageable);
		if (page.isEmpty()) {
			throw new ResourceNotFoundException("No books found");
		}

		return page;
	}

	public Page<Book> getBooksByPriceAsc(Pageable pageable) {
		Page<Book> page = bookRepository.findByOrderByPriceAsc(pageable);
		if (page.isEmpty()) {
			throw new ResourceNotFoundException("No books found");
		}

		return page;
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public Book findById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found"));
	}

	public void updateBook(Long id, Book updateBook) {
		Book existingBook = findById(id);

		existingBook.setAuthor(updateBook.getAuthor());
		existingBook.setTitle(updateBook.getTitle());
		existingBook.setGenre(updateBook.getGenre());
		existingBook.setPublishedDate(updateBook.getPublishedDate());
		existingBook.setPrice(updateBook.getPrice());

		bookRepository.save(existingBook);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
