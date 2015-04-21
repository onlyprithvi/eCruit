package edu.mum.cs544.project.ecruit.convertTotxt.core;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DocParser {
	private static Document document;

	public static void setDocument(Document doc){
		document=doc;
	}

	public static String getName() {
		String name = "";
		for (Element e : document.getElementsByClass("full-name")) {
			name = e.text();
		}
		return name;
	}

	public static String getLocation() {
		String location = "";

		for (Element e : (document.getElementById("location"))
				.getElementsByClass("locality")) {
			location = e.text();

		}
		return location;
	}

	public static String getIndustry() {
		String industry = "";

		for (Element e : document.getElementsByClass("industry")) {
			industry = e.text();

		}
		return industry;
	}

	public static List<String> getSkillSet() {
		List<String> skills = new ArrayList<String>();
		for (Element e : document.getElementsByClass("endorse-item")) {
			skills.add(e.text());
		}
		return skills;
	}

	public static List<String> getEducation() {
		List<String> edu = new ArrayList<String>();
		for (Element e : (document.getElementById("background-education")
				.getElementsByClass("degree"))) {
			edu.add(e.text());
		}
		return edu;

	}

	public static int getExperience() {

		Element experience = document.getElementById("background-experience");
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
				String yr = elementText.replaceAll("YEAR.*", "");
				noOfMonth += Integer.parseInt(yr.trim()) * 12;
			}
			if (elementText.contains("MONTH")) {
				String month = elementText.replaceAll(".*YEAR.", "").trim();
				month = month.replaceAll("MONTH.*", "");
				noOfMonth += Integer.parseInt(month.trim());
			}
		}
		return (noOfMonth);
	}

	
}
