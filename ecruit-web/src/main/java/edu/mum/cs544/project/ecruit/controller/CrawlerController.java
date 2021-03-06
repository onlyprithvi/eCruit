package edu.mum.cs544.project.ecruit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs544.project.ecruit.service.impl.CrawlerService;

@Controller
@RequestMapping(value = "/a")
public class CrawlerController {

	private String mainView;
	
	@Autowired
	CrawlerService crawlerService;

	public CrawlerController() {
		mainView = "/layouts/main";
	}

	@RequestMapping(value = "/crawl", method = RequestMethod.POST)
	public String doCrawl(@RequestParam("crawlerURL") String crawlerURL,RedirectAttributes redirectAttr) throws IOException {
		crawlerService.setUrl(crawlerURL);
		crawlerService.setPoolSize(10);
		crawlerService.executeCrawl();
		redirectAttr.addFlashAttribute("message",
				"Crawling has been started in backend.....");
		return "redirect:/a/crawl";
	}
	
	@RequestMapping(value = "/crawl/stop", method = RequestMethod.GET)
	public String stopCrawl(RedirectAttributes redirectAttr) throws IOException {
		crawlerService.stopCrawler();
		redirectAttr.addFlashAttribute("message",
				"Crawling has been stop.....");
		return "redirect:/a/crawl";
	}

	@RequestMapping(value = "/crawl", method = RequestMethod.GET)
	public String goCrawl(Model model) {
		model.addAttribute("partials", "/user/crawler");
		return mainView;
	}

}
