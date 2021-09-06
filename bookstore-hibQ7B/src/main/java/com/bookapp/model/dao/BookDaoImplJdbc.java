package com.bookapp.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
@Repository
public class BookDaoImplJdbc implements BookDao {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Book> getAllBooks() {
		return null;
	}

	@Override
	public Book addBook(Book book) {
		return null;
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
