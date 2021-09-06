package com.bookapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dao.BookDaoImplJdbc;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
@Import(BbConfig.class)
//@ImportResource: for loading xml conf with java config, avoidable
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean(name = "bookService")
	public BookService getBookService(BookDao bookDao) {
		BookServiceImpl bookService = new BookServiceImpl();
		bookService.setBookDao(bookDao);
		return bookService;

	}

	@Bean
	public BookDao getAccountDao(DataSource dataSource) {
		BookDaoImplJdbc accountDao = new BookDaoImplJdbc();
		accountDao.setDataSource(dataSource);
		return accountDao;
	}
}
