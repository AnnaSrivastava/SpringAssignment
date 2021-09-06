package com.bookapp.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class BookDaoImplJdbc implements BookDao {

	private DataSource dataSource;
	private BookDao dao=new BookDaoImpl();
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Book> getAllBooks() {
		System.out.println("some jdbc code to pick all the books");
		try {
			Connection connection=dataSource.getConnection();
			System.out.println("conn is done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dao.getAllBooks();
	}

	@Override
	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
		return;
		
	}

	@Override
	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
		return;
		
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

	

}
