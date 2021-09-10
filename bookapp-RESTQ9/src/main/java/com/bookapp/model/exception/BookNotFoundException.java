package com.bookapp.model.exception;

public class BookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -842492211724508645L;

	public BookNotFoundException(String message) {
		super(message);
	}
}