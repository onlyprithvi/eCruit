package edu.mum.cs544.project.ecruiter.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {

	@Id
	private String url;
	private String name;
	private String industry;
	private int experience;

	@ElementCollection
	@CollectionTable
	private List<String> skills = new ArrayList<String>();
	@ElementCollection
	@CollectionTable
	private List<String> education = new ArrayList<String>();

	// private List<String> certificate=new ArrayList<String>();

	public String getUrl() {
		return url;
	}

	public Profile() {
	}

	public Profile(String url, String name, String industry,
			List<String> skills, List<String> education, int experience) {
		super();
		this.url = url;
		this.name = name;
		this.industry = industry;
		this.skills = skills;
		this.education = education;
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getEducation() {
		return education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}

	public void addSkill(String skill) {
		if (!skills.contains(skill)) {
			skills.add(skill);
		}
	}

}
