package com.bookapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@PropertySource("classpath:db.properties")
@Configuration
public class DbConfig {

	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String password;
	
	@Value("${jdbc.password}")
	private String username;
	
	@Value("${jdbc.driverName}")
	private String driverClassName;
	
	@Bean
	public DriverManagerDataSource getDriverManager() {
		System.out.println("-----------");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}
}
