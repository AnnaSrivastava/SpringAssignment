package com.bookapp.model.exceptions;

public class BookNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -2590359224855048407L;

	public BookNotFoundException(String message) {
		super(message);
	}
}