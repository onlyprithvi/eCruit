package edu.mum.cs544.project.ecruiter.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruiter.dao.ProfileDao;
import edu.mum.cs544.project.ecruiter.domain.Profile;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class ProfileService {
	ProfileDao profileDao;
	public ProfileService(){}
	
	public void save(String url,String name,String industry, List<String> skills,List<String> education,int experience){
		profileDao.addProfile(url,name,industry, skills,education,experience);
	}
	
	public Profile get(String url){
		return profileDao.getProfile(url);
	}

	@Transactional(propagation=Propagation.SUPPORTS)

	public ProfileDao getProfileDao() {
		return profileDao;
	}
	@Transactional(propagation=Propagation.SUPPORTS)

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

}
