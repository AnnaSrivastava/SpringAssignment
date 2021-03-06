package com.bookapp.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bookapp.model.entities.Book;
import com.bookapp.model.exceptions.BookNotFoundException;

@Repository
@Primary
public class BookDaoImplHib implements BookDao {

	private SessionFactory sessionFactory;

	@Autowired
	public BookDaoImplHib(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("select b from Book b", Book.class).getResultList();
	}

	@Override
	public void addBook(Book book) {
		getSession().persist(book);
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);

		getSession().delete(book);
	}

	@Override
	public void updateBook(int id, Book book) {
		getSession().merge(book);
	}

	@Override
	public Book getBookById(int id) {
		Book book = getSession().find(Book.class, id);

		if (book == null)
			throw new BookNotFoundException("book with id " + id + " is found");
		return book;
	}

}