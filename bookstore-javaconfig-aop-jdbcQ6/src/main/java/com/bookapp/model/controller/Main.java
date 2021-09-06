package com.bookapp.model.controller;
import java.util.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.config.AppConfig;
import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService=(BookService) ctx.getBean("bookService", BookService.class);
		List<Book>books=bookService.getAllBooks();
		books.forEach(b-> System.out.println(b));
	}
}
