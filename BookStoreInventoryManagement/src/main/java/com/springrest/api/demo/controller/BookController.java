package com.springrest.api.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.api.demo.model.Book;
import com.springrest.api.demo.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getByAuthor(@RequestParam String author){
		List<Book> books = bookService.getBooksByAuthor(author);
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/genre")
	public ResponseEntity<Page<Book>> getByGenre(@RequestParam String genre,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
			){
		Pageable pageable = buildPageable(page, size, "title", "asc");
        return ResponseEntity.ok(bookService.getBooksByGenre(genre, pageable));
	}
	
	@GetMapping("/cheaper")
	public ResponseEntity<List<Book>> getBooksCheaperThan(@RequestParam Double maxPrice){
		return ResponseEntity.ok(bookService.getBooksCheaperThan(maxPrice));
	}
	
	@GetMapping("/expensive")
	public ResponseEntity<List<Book>> getBooksExpensiveThan(@RequestParam Double price){
		return ResponseEntity.ok(bookService.getBooksHigherPrice(price));
	}
	
	@GetMapping("/new-arrival")
	public ResponseEntity<List<Book>> getBooksPublishedAfterDate(@RequestParam LocalDate date){
		return ResponseEntity.ok(bookService.getBooksPublishedAfter(date));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBooksByKeyword(@RequestParam String keyword){
		return ResponseEntity.ok(bookService.searchByTitleKeyword(keyword));
	}
	
	@GetMapping("/genre-author")
	public ResponseEntity<List<Book>> getByGenreAndAuthor(@RequestParam String genre, @RequestParam String author){
		return ResponseEntity.ok(bookService.getBooksByGenreAndAuthor(genre, author));
	}
	
	@GetMapping("/genre-or-author")
	public ResponseEntity<List<Book>> getByGenreOrAuthor(@RequestParam String genre, @RequestParam String author){
		return ResponseEntity.ok(bookService.getBooksByGenreOrAuthor(genre, author));
	}
	
	@GetMapping("/price-range")
	public ResponseEntity<List<Book>> getInPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice){
		return ResponseEntity.ok(bookService.getBooksPriceInRange(minPrice, maxPrice));
	}
	
	@GetMapping("/genre-discont")
	public ResponseEntity<List<Book>> getBooksByGenreUnderPrice(@RequestParam String genre, @RequestParam Double maxPrice){
		return ResponseEntity.ok(bookService.getBooksByGenreAndBelowPrice(genre, maxPrice));
	}
	
	@GetMapping("/latest")
	public ResponseEntity<Page<Book>> getLatestBooks(@RequestParam(defaultValue = "0") int page,
													@RequestParam(defaultValue = "10") int size,
													@RequestParam(defaultValue = "publishedDate") String sortBy,
													@RequestParam(defaultValue = "desc") String sortDir){
		Pageable pageable = buildPageable(page, size, sortBy, sortDir);
		return ResponseEntity.ok(bookService.getBooksInDes(pageable));
	}
	
	@GetMapping("/by-price")
	public ResponseEntity<Page<Book>> getBooksByPriceAsc(@RequestParam(defaultValue = "0") int page,
														@RequestParam(defaultValue = "10") int size,
														@RequestParam(defaultValue = "price") String sortBy,
														@RequestParam(defaultValue = "asc") String sortDir){
		Pageable pageable = buildPageable(page, size, sortBy, sortDir);
		return ResponseEntity.ok(bookService.getBooksByPriceAsc(pageable));
	}
	
	@PostMapping
	public ResponseEntity<String> saveBook(@RequestBody Book book){
		bookService.saveBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body("Book save successfully");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id){
		return ResponseEntity.ok(bookService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updateBook){
		bookService.updateBook(id, updateBook);
		return ResponseEntity.ok("Book updated Successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
		return ResponseEntity.ok("Book deleted Successfully");
	}
	
	
	private Pageable buildPageable(int page, int size, String sortBy, String sortDir) {
		Sort.Direction direction = "desc".equalsIgnoreCase(sortDir) ?
				Sort.Direction.DESC : Sort.Direction.ASC;
		
		return PageRequest.of(page, size, Sort.by(direction, sortBy));
	}
}

