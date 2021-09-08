package com.bookapp.model.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.config.AppConfig;
import com.bookapp.model.entities.Book;
import com.bookapp.model.service.BookService;

public class Main {

	public static void main(String[] args) {
		//Spring core
		
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("bookapp.xml");
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookService bookService=ctx.getBean("bookService", BookService.class);
		List<Book>books=bookService.getAllBooks();
		bookService.addBook(new Book("AQ123", "80/20 rule", "xyz", 400));
		bookService.addBook(new Book("AQ523", "basics physics", "abc", 300));

		books.forEach(b-> System.out.println(b));
	}
}
