package com.bookapp.web.controller.exceptionhandlers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MyGlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle404() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("404");
		mv.addObject("message", "resource is not found");
		return mv;
	}
	
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDataAccessException() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("dberror");
		mv.addObject("message", "pls try after some time");
		return mv;
	}
	
	
}
