package com.bookapp.model.dao;
import java.util.*;
public interface BookDao {
	public List<Book> getAllBooks();
	public void addBook(Book book);
	public void deleteBook(int id);
	public void updateBook(int id, Book book);
}
