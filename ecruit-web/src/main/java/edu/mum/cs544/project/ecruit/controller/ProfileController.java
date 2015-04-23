package edu.mum.cs544.project.ecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.project.ecruit.domain.Profile;
import edu.mum.cs544.project.ecruit.domain.UserInputFilter;
import edu.mum.cs544.project.ecruit.service.ProfileService;
import edu.mum.cs544.project.ecruit.service.impl.QueryFilterService;
import edu.mum.cs544.project.ecruit.util.SecurityUtil;

@Controller
@RequestMapping(value="profiles")
public class ProfileController {

	static int pageSize=10;
	
	@Autowired
	ProfileService service;
	
	@Autowired
	QueryFilterService queryService;

	@RequestMapping("")
	public String getAllProfiles(@RequestParam("page")Integer page, Model m) {
		
		List<Profile> profileLst = service.getAllProfiles(page,pageSize);
		Long maxPageno= service.getMaxPage(pageSize);
		m.addAttribute("userFilter", new UserInputFilter());
		m.addAttribute("profiles", profileLst);
		m.addAttribute("partials", "user/viewProfiles");
		m.addAttribute("pageno", page);
		m.addAttribute("maxPageno", maxPageno);
		return "layouts/main";
	}
	

	@RequestMapping(value = "", method = RequestMethod.POST, params = "save")
	public String saveFilter(
			@ModelAttribute("userFilter") UserInputFilter filter, Model m) {
		List<Profile> profileLst = queryService.saveUserFilter(
				Long.parseLong(SecurityUtil.getSessionUser().getId()
						.toString()), filter);
		m.addAttribute("userFilter", filter);
		m.addAttribute("partials", "user/viewProfiles");
		m.addAttribute("profiles", profileLst);

		return "layouts/main";
	}

	@RequestMapping(value = "", method = RequestMethod.POST, params = "apply")
	public String applyFilter(
			@ModelAttribute("userFilter") UserInputFilter filter, Model m) {
		List<Profile> profileLst = queryService.executeUserFilter(filter);
		System.out.println("Filter CALLED" + filter.getIndustry());
		m.addAttribute("userFilter", filter);
		m.addAttribute("partials", "user/viewProfiles");
		m.addAttribute("profiles", profileLst);
		return "layouts/main";
	}
}
