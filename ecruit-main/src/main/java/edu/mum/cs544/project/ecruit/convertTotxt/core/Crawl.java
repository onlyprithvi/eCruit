package edu.mum.cs544.project.ecruit.convertTotxt.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.cs544.project.ecruiter.service.ProfileService;
import edu.mum.cs544.project.ecruiter.service.RecruiterService;

public class Crawl {

	static ProfileService profileService;
	static ApplicationContext context;
	
	static Set<String>  s = new HashSet<String>();

	public static void main(String[] args) throws IOException {
		context= new ClassPathXmlApplicationContext("context.xml");
		profileService= context.getBean("profileService",ProfileService.class);
//		crawl("http://np.linkedin.com/in/aprithvi");
		recruit();
	}

	private static void recruit() {
		// TODO Auto-generated method stub
		List<String> industries=new ArrayList<String>();
		industries.add("IT");
		industries.add("Management");
		
		List<String> skills=new ArrayList<String>();
		skills.add("java");
		skills.add("c++");
		skills.add("c");
		
		List<String> educations=new ArrayList<String>();
		educations.add("Masters");
		educations.add("Bachelors");
		
		

		
		

		
		
		RecruiterService rs=context.getBean("recruiterService",RecruiterService.class);
		rs.createRecruiter("Kaushal");
		rs.addFilter(1, industries, educations, skills, 20);
		
		rs.createRecruiter("Prithvi");
		rs.addFilter(2, industries, educations, skills, 30);
		
		
	}

	public static ProfileService getProfileService() {
		return profileService;
	}

	public static void setProfileService(ProfileService service) {
		Crawl.profileService = service;
	}

	public static void crawl(String url) throws IOException {
		System.out.println(url);
		Document doc = Jsoup.connect(url).timeout(10000).get();
		try {
			DocParser.setDocument(doc);
			profileService.save(url,DocParser.getName(),DocParser.getIndustry(),DocParser.getSkillSet(),DocParser.getEducation(),DocParser.getExperience());
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
