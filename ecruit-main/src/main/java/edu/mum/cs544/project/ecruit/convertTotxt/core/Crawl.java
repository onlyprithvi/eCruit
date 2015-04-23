package edu.mum.cs544.project.ecruit.convertTotxt.core;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs544.project.ecruit.profile.ProfileService;

public class Crawl {

	//@Autowired//
	ProfileService profileService;

	static Set<String> s = new HashSet<String>();

/*	public static void main(String[] args) throws IOException {
		//context = new ClassPathXmlApplicationContext("context.xml");

		crawl("https://www.linkedin.com/in/deeprisal");
		//recruit();

	}*/

	/*
	 * private static void recruit() { // TODO Auto-generated method stub
	 * 
	 * 
	 * List<String> skills=new ArrayList<String>(); skills.add("Java");
	 * 
	 * List<String> educations=new ArrayList<String>(); educations.add("BIM,");
	 * educations.add("Masters in computer science,");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * QueryFilterService
	 * rs=context.getBean("queryFilterService",QueryFilterService.class); //
	 * rs.createRecruiter("Kaushal"); rs.addFilter(1,
	 * "Information Technology and Services", educations, skills, 20,"one");
	 * 
	 * // rs.createRecruiter("Prithvi"); // rs.addFilter(2, "Computer Software",
	 * educations, skills, 30,"Two"); // // QueryFilterService qfs=new
	 * QueryFilterService(); List<Profile>
	 * profiles=queryFilterService.executeQueryFilter(1, 1);
	 * 
	 * for(Profile p:profiles){ // p.toString();
	 * System.out.println(p.toString()); }
	 * 
	 * 
	 * }
	 */

	// @Async
	public  void crawl(String url) throws IOException {
		System.out.println(url);
		Document doc = Jsoup.connect(url).timeout(10000).get();
		try {
			DocParser.setDocument(doc);
			profileService.save(url, DocParser.getName(),
					DocParser.getIndustry(), DocParser.getSkillSet(),
					DocParser.getEducation(), DocParser.getExperience());
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
