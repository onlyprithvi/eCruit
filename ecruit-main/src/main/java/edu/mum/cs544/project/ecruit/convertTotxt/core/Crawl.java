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
import org.springframework.scheduling.annotation.Async;

import edu.mum.cs544.project.ecruiter.domain.Profile;
import edu.mum.cs544.project.ecruiter.service.ProfileService;
import edu.mum.cs544.project.ecruiter.service.QueryFilterService;
import edu.mum.cs544.project.ecruiter.service.RecruiterService;

public class Crawl {

	static ProfileService profileService;
	static ApplicationContext context;
	static QueryFilterService queryFilterService;
	
	static Set<String>  s = new HashSet<String>();

	public static void main(String[] args) throws IOException {
		context= new ClassPathXmlApplicationContext("context.xml");
//		profileService= context.getBean("profileService",ProfileService.class);
//		crawl("http://np.linkedin.com/in/aprithvi");
		recruit();
	}

	private static void recruit() {
		// TODO Auto-generated method stub
		
		
		List<String> skills=new ArrayList<String>();
		skills.add("Java");
		
		List<String> educations=new ArrayList<String>();
		educations.add("BIM,");
		educations.add("Masters in computer science,");
		
		

		
		

		
		
		RecruiterService rs=context.getBean("recruiterService",RecruiterService.class);
		rs.createRecruiter("Kaushal");
		rs.addFilter(1, "Information Technology and Services", educations, skills, 20,"one");
		
//		rs.createRecruiter("Prithvi");
//		rs.addFilter(2, "Computer Software", educations, skills, 30,"Two");
//		
//		QueryFilterService qfs=new QueryFilterService();
		List<Profile> profiles=queryFilterService.executeQueryFilter(1, 1);
		
		for(Profile p:profiles){
//			p.toString();
			System.out.println(p.toString());
		}
		
		
	}

	public static QueryFilterService getQueryFilterService() {
		return queryFilterService;
	}

	public static void setQueryFilterService(QueryFilterService queryFilterService) {
		Crawl.queryFilterService = queryFilterService;
	}

	public static ProfileService getProfileService() {
		return profileService;
	}

	public static void setProfileService(ProfileService service) {
		Crawl.profileService = service;
	}
	
//	@Async
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
