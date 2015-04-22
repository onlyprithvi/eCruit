package edu.mum.cs544.project.ecruiter.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Recruiter {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<QueryFilter> filters=new ArrayList<QueryFilter>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFilters(List<QueryFilter> filter){
		this.filters=filter;
	}
	public void addFilter(QueryFilter filter){
		if(!filters.contains(filter)){
			filters.add(filter);
		}
	}
	public Recruiter(String name){
		this.name=name;
	}
	
	
	
	public Recruiter(){}

	

}
