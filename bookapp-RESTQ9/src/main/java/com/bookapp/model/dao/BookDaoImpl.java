package com.bookapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapp.model.entities.Book;
import com.bookapp.model.exception.BookNotFoundException;

@Repository
public class BookDaoImpl implements BookDao{

	private EntityManager em;
	
	@Autowired
	public BookDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("select b from Book b", Book.class).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		 em.merge(book);
		 return book;
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate=getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		em.merge(bookToUpdate);
		
		return bookToUpdate;
	}

	@Override
	public Book getBookById(int id) {
		Book book=em.find(Book.class, id);
		if(book==null)
			throw new BookNotFoundException("book with id "+ id +" is not found");
		return book;
	}

	@Override
	public Book deleteBook(int id) {
		Book book=getBookById(id);
		em.remove(book);
		return book;
	}

}