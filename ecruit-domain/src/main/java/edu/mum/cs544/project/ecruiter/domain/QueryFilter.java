package edu.mum.cs544.project.ecruiter.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QueryFilter {
	@Id
	@GeneratedValue
	private int id;
	@ElementCollection
	@CollectionTable
	private List<String> industries=new ArrayList<String>();
	
	@ElementCollection
	@CollectionTable
	private List<String> skills=new ArrayList<String>();
	
	@ElementCollection
	@CollectionTable
	private List<String> educations=new ArrayList<String>();
	
	private int minimumExperience;
	
	public QueryFilter(){}
	
	
	public QueryFilter(List<String> industries, List<String> skills,
			List<String> educations,int minimumExperience) {
		super();
		this.industries = industries;
		this.skills = skills;
		this.educations = educations;
		this.minimumExperience=minimumExperience;
	}
	
	public int getMinimumExperience() {
		return minimumExperience;
	}

	public void setMinimumExperience(int minimumExperience) {
		this.minimumExperience = minimumExperience;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getIndustries() {
		return industries;
	}
	public void setIndustries(List<String> industries) {
		this.industries = industries;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getEducations() {
		return educations;
	}
	public void setEducations(List<String> educations) {
		this.educations = educations;
	}
	
	public void addIndustry(String industry){
		if(!industries.contains(industry)){
			industries.add(industry);
		}
	}
	public void addSkill(String skill){
		if(!skills.contains(skill)){
			skills.add(skill);
		}
	}
	public void addEducation(String education){
		if(!educations.contains(education)){
			educations.add(education);
		}
	}
	
	
	
	

}
