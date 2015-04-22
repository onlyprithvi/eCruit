package edu.mum.cs544.project.ecruiter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruiter.domain.Profile;
@Transactional(propagation=Propagation.MANDATORY)
public class ProfileDao {
	SessionFactory sf;
	
	public void addProfile(String url,String name,String industry, List<String> skills,List<String> education,int experience){
		Profile pro=new Profile(url,name,industry, skills,education,experience);
		sf.getCurrentSession().save(pro);
		
	}
	public Profile getProfile(String url){
		return (Profile) sf.getCurrentSession().get(Profile.class, url);
		
	}
	@Transactional(propagation=Propagation.SUPPORTS)

	public SessionFactory getSf() {
		return sf;
	}
	@Transactional(propagation=Propagation.SUPPORTS)

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

}
