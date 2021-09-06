package com.bookapp.model.dao;

import java.util.*;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class BookDaoImpl implements BookDao{

	private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
	private static int counter = 0;
	static {
		booksMap.put(++counter, new Book(counter, "ABC123", "Head first Java" , "Katthy", 600));
		booksMap.put(++counter,  new Book(counter, "ABC723", "Servlet jsp Java" , "Katthy", 700));
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(booksMap.values());
	}

	@Override
	public Book addBook(Book book) {
		System.out.println("hgfugf");
		book.setId(++counter);
		booksMap.put(counter, book);
		return booksMap.get(counter);
	}

	@Override
	public void deleteBook(int id) {
		booksMap.remove(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		booksMap.put(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return booksMap.get(id);
	}
	
}
