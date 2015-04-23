package edu.mum.cs544.project.ecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.project.ecruit.domain.Profile;
import edu.mum.cs544.project.ecruit.domain.QueryFilter;
import edu.mum.cs544.project.ecruit.domain.UserInputFilter;
import edu.mum.cs544.project.ecruit.service.impl.QueryFilterService;
import edu.mum.cs544.project.ecruit.util.SecurityUtil;

@Controller
public class QueryController {
	@Autowired
	QueryFilterService queryService;
	
	@RequestMapping(value="viewQuery")
	public String viewSavedQueries(Model model){
		List<QueryFilter> queries=queryService.getAllQueryFilters(SecurityUtil.getSessionUser().getId());
		model.addAttribute("queries", queries);
		model.addAttribute("partials", "user/query-list");
		return "layouts/main";
	}
	
	@RequestMapping(value="query")
	public String executeSavedQuery(@RequestParam("id") int id,Model model){
		List<Profile> profiles=queryService.executeQueryFilter(id);
		model.addAttribute("profiles", profiles);
		model.addAttribute("partials", "user/viewProfiles");
		model.addAttribute("userFilter", new UserInputFilter());
		return "layouts/main";
		
	}

}
