package com.bookapp.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImplJdbc implements BookDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> getAllBooks() {
		String FIND_ALL = "select * from books_table";	
		return jdbcTemplate.query(FIND_ALL,new BeanPropertyRowMapper<Book>(Book.class));
	}


	@Override
	public void addBook(Book book) {
		String INSERT_QUERY = "insert into account(isbn, title, author, price) values(?,?,?,?)";
		jdbcTemplate.update(INSERT_QUERY, 
				new Object[] { book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice() });
	}

	@Override
	public void deleteBook(int id) {
		String DELETE_QUERY = "delete from account where id=?";
		jdbcTemplate.update(DELETE_QUERY, new Object[] {id});		
	}

	@Override
	public void updateBook(int id, Book book) {
		String UPDATE_QUERY = "update books_table set price =? where id=?";
		jdbcTemplate.update(UPDATE_QUERY, new Object[] {book.getPrice(), book.getId()});
	}

}
