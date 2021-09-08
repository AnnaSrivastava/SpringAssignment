package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.entities.Book;
@Service(value = "bookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, isolation = Isolation.REPEATABLE_READ)
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
