package com.bookapp.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
// step 1: apply validation in pojo : jsr 303 wale
@Entity
@Table(name = "book_table_hib_spring2")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String isbn;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String author;
	
	@Digits(integer = 10, fraction = 2, message = "price should be in correct format")
	private Double price;

	@Enumerated(EnumType.STRING)
	private BookType bookType;

	@Past(message = "date should be past date in dd/mm/yyyy fomat")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date pubDate;

	public Book(String isbn, String title, String author, Double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book(int id, String isbn, String title, String author, Double price) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price
				+ "]";
	}

}
