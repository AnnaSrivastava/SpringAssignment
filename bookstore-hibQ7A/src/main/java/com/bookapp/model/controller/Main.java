package com.bookapp.model.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.entities.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bookapp.xml");
		BookService bookService=ctx.getBean("bookService", BookService.class);
		bookService.addBook(new Book("AW12", "rich dad poor dad", "rk", 400));
	}
}
