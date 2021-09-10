package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bookapp.model.service.BookService;

@SpringBootApplication
@EnableTransactionManagement
public class BookappRestApplication{

	@SuppressWarnings("unused")
	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookappRestApplication.class, args);
	}

}