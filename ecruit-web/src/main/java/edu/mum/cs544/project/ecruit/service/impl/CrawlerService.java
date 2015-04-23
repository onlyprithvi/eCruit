package edu.mum.cs544.project.ecruit.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.project.ecruit.crawler.DocParser;
import edu.mum.cs544.project.ecruit.service.ProfileService;

@Service
public class CrawlerService {

	@Autowired
	ProfileService profileService;
	private  ExecutorService pool;
	private String url = "";
	static Set<String> s = new HashSet<String>();
	private boolean doCrawl=true;

	public CrawlerService() {

	}

	public CrawlerService(int poolSize, String url) {
		pool = Executors.newFixedThreadPool(poolSize);
		this.url = url;
	}

	public void executeCrawl() {
		doCrawl=true;
		pool.execute(new Runnable() {
			public void run() {
				try {
					crawl(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void crawl(String url) throws IOException {
		if(!doCrawl)return;
		System.out.println(url);
		Document doc = Jsoup.connect(url).timeout(10000).get();
		try {
			DocParser.setDocument(doc);
			profileService.save(url, DocParser.getName(),
					DocParser.getIndustry(), DocParser.getSkillSet(),
					DocParser.getEducation(), DocParser.getExperience());
		} catch (Exception e) {
		}

		Elements questions = doc.select("a[href]");
		for (Element element : questions) {
			if (element.toString().matches(".*www.linkedin.com/pub.*")
					&& !element.toString().matches(".*/dir/.*")) {

				String link = element.toString().replaceAll("<img.*?>", "");

				link = link.replaceAll("<a.*?href=\"", "");
				link = link.replaceAll("</a>", "");
				link = link.replaceAll("\".*", " ");
				link = link.replaceAll("\\?.*", "");
				link = link.trim();
				if (!s.contains(link)) {
					s.add(link);
					System.out.println("next crawl =" + link);
					crawl(link);
				}
			}
		}
	}
	
	
	
	public void stopCrawler(){
		doCrawl=false;
		 

		   
	}

	public void setUrl(String crawlerURL) {
		this.url = crawlerURL;

	}

	public void setPoolSize(int i) {
		this.pool = Executors.newFixedThreadPool(10);

	}

}
