package edu.mum.cs544.project.ecruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/a")
public class CrawlerController {

	private String mainView;

	public CrawlerController() {
		mainView = "/layouts/main";
	}

	@RequestMapping(value = "/crawl/{crawlerURL}", method = RequestMethod.GET)
	public String doCrawl(@PathVariable String crawlerURL) {
		return "";
	}

	@RequestMapping(value = "/crawl", method = RequestMethod.GET)
	public String goCrawl(Model model) {
		model.addAttribute("partials", "/user/crawler");
		return mainView;
	}

}
