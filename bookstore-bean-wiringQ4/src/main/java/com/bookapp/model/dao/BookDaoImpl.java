package com.bookapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
//@Getter
//@Setter
public class BookDaoImpl implements BookDao{

	private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
	private static int counter = 0;
//	static {
//		booksMap.put(++counter, new Book(counter, "ABC123", "Head first Java" , "Katthy", 600));
//		booksMap.put(++counter,  new Book(counter, "ABC723", "Servlet jsp Java" , "Katthy", 700));
//	}

	
	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(booksMap.values());
	}
	
	public static Map<Integer, Book> getBooksMap() {
		return booksMap;
	}

	public static void setBooksMap(Map<Integer, Book> booksMap) {
		BookDaoImpl.booksMap = booksMap;
	}

	@Override
	public Book addBook(Book book) {
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
