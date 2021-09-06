package com.bookapp.model.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

public class Main {

	public static void main(String[] args) {
		//Spring core
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bookapp.xml");
		BookService bookService=ctx.getBean("BookService", BookService.class);
		List<Book>books=bookService.getAllBooks();
		books.forEach(b-> System.out.println(b));
	}
}
