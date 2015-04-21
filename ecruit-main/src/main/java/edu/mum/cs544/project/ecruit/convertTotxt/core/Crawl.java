package edu.mum.cs544.project.ecruit.convertTotxt.core;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.cs544.project.ecruiter.service.ProfileService;

public class Crawl {

	static ProfileService service;
	
	static Set<String>  s = new HashSet<String>();

	public static void main(String[] args) throws IOException {
		ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
		service= context.getBean("service",ProfileService.class);
		crawl("http://np.linkedin.com/in/aprithvi");
	}

	public static ProfileService getService() {
		return service;
	}

	public static void setService(ProfileService service) {
		Crawl.service = service;
	}

	public static void crawl(String url) throws IOException {
		System.out.println(url);
		Document doc = Jsoup.connect(url).timeout(10000).get();
		try {
			DocParser.setDocument(doc);
			service.save(url,DocParser.getName(),DocParser.getIndustry(),DocParser.getSkillSet(),DocParser.getEducation(),DocParser.getExperience());
		} catch (Exception e) {
			e.printStackTrace();
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
}
