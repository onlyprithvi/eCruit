package edu.mum.cs544.project.ecruit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs544.project.ecruit.domain.User;

@Controller
@SessionAttributes("authenitcatedUser")
public class SecurityNavigation {

	@RequestMapping(value = "/")
	public String mainPage(HttpServletRequest request,Model model) {
		User user = (User) request.getSession().getAttribute(
				"authenitcatedUser");
		if (user != null) {
			model.addAttribute("partials", "user/dashboard");
			return "layouts/main";
		} else
			return "login";

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
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView showDashboard() {
		ModelAndView modelAndView = new ModelAndView("layouts/main");
		modelAndView.addObject("partials", "user/dashboard");
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		modelAndView.addObject("authenitcatedUser", user);	
		return modelAndView;
	}

}
