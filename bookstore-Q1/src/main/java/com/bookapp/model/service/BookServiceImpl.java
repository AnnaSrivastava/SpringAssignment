package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;

public class BookServiceImpl implements BookService{

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	@Override
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
