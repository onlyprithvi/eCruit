package edu.mum.cs544.project.ecruit.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs544.project.ecruit.domain.UserInputFilter;
import edu.mum.cs544.project.ecruit.service.ProfileService;
import edu.mum.cs544.project.ecruiter.domain.Profile;

@Controller
@RequestMapping(value="profiles")
public class ProfileController {

	@Autowired
	ProfileService service;
	
	@RequestMapping("")
	public String getAllProfiles(Model m){
		List<Profile> profileLst= service.getAllProfiles();
		m.addAttribute("filter",new UserInputFilter());
		m.addAttribute("profiles",profileLst);
		m.addAttribute("partials", "user/viewProfiles");
		return "layouts/main";
	}
}
