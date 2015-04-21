package edu.mum.cs544.project.ecruit.convertTotxt.core;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DocParser {
	public Profile parser(Document doc) throws Exception {
		Profile profile = new Profile();
		for (Element e : doc.getElementsByClass("full-name")) {
			profile.setFullName(e.text());
		}
		Element eLocation = doc.getElementById("location");
		for (Element e : eLocation.getElementsByClass("locality")) {
			profile.setLocation(e.text());
		}
		for (Element e : eLocation.getElementsByClass("industry")) {
			profile.setIndrustry(e.text());
		}
		for (Element e : doc.getElementsByClass("endorse-item")) {
			profile.addSkillSet(e.text());
		}
		Element eEducation = doc.getElementById("background-education");
		for (Element e : eEducation.getElementsByClass("degree")) {
			profile.addEdulvls(e.text());
		}

		Element experience = doc.getElementById("background-experience");
		int noOfMonth = 0;
		for (Element e : experience
				.getElementsByClass("experience-date-locale")) {
			
			String elementText = e.text();
			int bracesPositionOpen = elementText.indexOf("(");
			int bracesPositionClose = elementText.indexOf(")");
			elementText = elementText
					.substring(bracesPositionOpen + 1, bracesPositionClose)
					.trim().toUpperCase();
			if (elementText.contains("YEAR")) {
				String yr=elementText.replaceAll("YEAR.*", "");
				noOfMonth+=Integer.parseInt(yr.trim())*12;
			}
			if (elementText.contains("MONTH")) {
				String month=elementText.replaceAll(".*YEAR.", "").trim();
				month=month.replaceAll("MONTH.*", "");
				noOfMonth+=Integer.parseInt(month.trim());
			}
		}
		profile.setExperience(noOfMonth);
		return profile;
	}
}
