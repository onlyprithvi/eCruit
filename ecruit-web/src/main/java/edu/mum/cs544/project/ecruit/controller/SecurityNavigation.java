package edu.mum.cs544.project.ecruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation {

	@RequestMapping(value = "/")
	public String mainPage() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}

	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", true);
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(SessionStatus status) {		
		return "redirect:/";
	}
	

}
