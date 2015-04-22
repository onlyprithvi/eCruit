package edu.mum.cs544.project.ecruit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs544.project.ecruit.domain.Role;
import edu.mum.cs544.project.ecruit.domain.User;
import edu.mum.cs544.project.ecruit.service.UserService;
import edu.mum.cs544.project.ecruit.validator.ConfirmPasswordValidator;
import edu.mum.cs544.project.ecruit.validator.UniqueUserNameAndPasswordValidator;

@Controller
@SessionAttributes("authenitcatedUser")
public class SecurityNavigation {

	@Autowired
	UserService userService;
	@Autowired
	ConfirmPasswordValidator confirmPasswordValidator;

	@Autowired
	UniqueUserNameAndPasswordValidator uniqueUserNameAndPasswordValidator;

	@RequestMapping(value = "/")
	public String mainPage(HttpServletRequest request, Model model) {
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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping("/register-success")
	public String registerSuccessPage() {
		return "register-success";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String pocessRegister(@ModelAttribute("user") @Valid User newUser,
			BindingResult result, Model model) {

		confirmPasswordValidator.validate(newUser, result);
		uniqueUserNameAndPasswordValidator.validate(newUser, result);
		
		if (result.hasErrors()) {
			return "register";
		}
		newUser.setRole(Role.User);
		User user = userService.saveUser(newUser);
		if (user != null) {
			return "redirect:/register-success";
		} else {
			model.addAttribute("message",
					"Sorry!!! Problem Occured in User Registration.");
			return "register-form";
		}
	}
	
	@RequestMapping("/check-availability/username/{username}")
	public String check(@PathVariable("username") String username, Model model) {
		User user = userService.findUserByLoginId(username);
	    if(user == null)
	    	model.addAttribute("error", false);
	    else
	    	model.addAttribute("error", true);
	    
	    return "validate_username";
	}


}
