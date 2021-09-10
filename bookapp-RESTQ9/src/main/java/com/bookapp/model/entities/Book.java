package com.bookapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "book_table")
public class Book{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Double price;
	

	public Book(String title, Double price) {
		this.title = title;
		this.price = price;
	}
	
	
	public Book( Integer id,String title, Double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	
	public Book() {	}
	
	
}