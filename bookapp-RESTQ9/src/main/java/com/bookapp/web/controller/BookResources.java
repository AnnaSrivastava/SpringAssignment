package com.bookapp.web.controller;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.dao.BookDao;
import com.bookapp.model.entities.Book;

@RestController//	@RestController=@Controller + @ResponseBody
@RequestMapping(path="api")
public class BookResources {

	@Autowired
	private BookDao dao;

	@GetMapping(value = "books")
	public ResponseEntity<Collection<Book>> getAllBooks() {
		Collection<Book> books = dao.getAllBooks();
		return new ResponseEntity<Collection<Book>>(books, HttpStatus.OK);
	}

	@GetMapping(value = "book/{id}")
	public ResponseEntity<Book> getAnBook(@PathVariable Integer id) {
		Book book = dao.getBookById(id);
//		book.add(linkTo(methodOn(BookResources.class).getAnBook(book.getId())).withSelfRel());
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping(path = "book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		System.out.println("fwdyhwdfdwh");
		Book savedBook = dao.addBook(book);
		return new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
	}

	@PutMapping(path = "book/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@PathVariable Integer id,
			@RequestBody Book book) {
		dao.updateBook(id, book);
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/api/book/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id)
			throws Exception {
		dao.deleteBook(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

}
