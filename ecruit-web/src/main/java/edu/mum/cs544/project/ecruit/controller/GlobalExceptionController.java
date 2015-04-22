package edu.mum.cs544.project.ecruit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs544.project.ecruit.exception.CustomGenericException;

@ControllerAdvice
public class GlobalExceptionController { 
	
	private ModelAndView modelAndView;

	public GlobalExceptionController() {
		modelAndView = new ModelAndView("layouts/main");
	}
	
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
		modelAndView.addObject("errTitle", ex.getTitle());
		modelAndView.addObject("errMessage", ex.getMessage()); 
		modelAndView.addObject("partials", "error/generic-error");
		return modelAndView; 
	}
 
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		modelAndView.addObject("errTitle", ex.getClass());
		modelAndView.addObject("errMessage", ex.getMessage()); 
		modelAndView.addObject("partials", "error/generic-error");
		return modelAndView;
	}
 
}
