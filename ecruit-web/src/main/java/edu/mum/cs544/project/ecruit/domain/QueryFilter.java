package edu.mum.cs544.project.ecruit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QueryFilter {
	@Id
	@GeneratedValue
	private int id;
	
	private String industry;
	private String filterName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable
	private List<String> skills=new ArrayList<String>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable
	private List<String> educations=new ArrayList<String>();
	
	private int minimumExperience;
	
	public QueryFilter(){}
	
	
	public QueryFilter(String industry, List<String> skills,
			List<String> educations,int minimumExperience,String filterName) {
		super();
		this.industry = industry;
		this.skills = skills;
		this.educations = educations;
		this.minimumExperience=minimumExperience;
		this.filterName=filterName;
	}
	
	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
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
	public List<String> getEducations() {
		return educations;
	}
	public void setEducations(List<String> educations) {
		this.educations = educations;
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
