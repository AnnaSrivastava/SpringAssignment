package com.bookapp.model.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.config.AppConfig;
import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

public class Main {

	public static void main(String[] args) {
		//Spring core
		
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("bookapp.xml");
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookService bookService=ctx.getBean("bookService", BookService.class);
		List<Book>books=bookService.getAllBooks();
		books.forEach(b-> System.out.println(b));
	}
}
