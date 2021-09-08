package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookapp.model.entities.Book;
import com.bookapp.model.entities.BookType;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// you can use whatever u like
	@GetMapping("allbooks")
	public String getAllbooks(ModelMap map) {
		map.addAttribute("books", bookService.getAllBooks());
		return "allbooks";
	}

	// ---------add an new book-------------
	@GetMapping("addbook")
	public String addBookGet(ModelMap map) {
		map.addAttribute("book", new Book());// it goes to the request scope
		return "addbook"; // requestDispacher
	}

	@PostMapping("addbook")
	public String addBookPost(@ModelAttribute(name = "book") @Valid Book book, 
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addbook";
		} else {
			if (book.getId() == 0) {
				bookService.addBook(book);
			} else {
				bookService.updateBook(book.getId(), book);
			}
			return "redirect:/allbooks"; // PRG
		}
	}

	// Spring mvc will run this code and whatever is return from this method is put
	// into request scope
	@ModelAttribute(name = "booktypes")
	public BookType[] getBookTypes() {
		System.out.println("-------getBookTypes @ModelAttribute-------");
		return BookType.values();
	}

	// ----------delete a book---------
	@GetMapping("deletebook")
	public String deleteBook(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id").trim());
		bookService.deleteBook(id);
		return "redirect:/allbooks"; // PRG
	}

	// ---------update-----------------
	@GetMapping("updatebook")
	public String updateBookGet(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("id").trim());
		Book book = bookService.getBookById(id);

		map.addAttribute("book", book);// it goes to the request scope

		return "updatebook"; // requestDispacher
	}

}
