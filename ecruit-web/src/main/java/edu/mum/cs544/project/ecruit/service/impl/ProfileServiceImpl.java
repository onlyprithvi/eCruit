package edu.mum.cs544.project.ecruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruit.domain.Profile;
import edu.mum.cs544.project.ecruit.repository.ProfileRepository;
import edu.mum.cs544.project.ecruit.service.ProfileService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	public List<Profile> getAllProfiles() {
		return profileRepository.getAllProfiles();
	}

	public void save(String url, String name, String industry,
			List<String> skills, List<String> education, int experience) {
		Profile pro=new Profile(url,name,industry, skills,education,experience);
		profileRepository.save(pro);
	}

	public Profile getProfile(String url) {
		return profileRepository.findProfileByURL(url);
	}

}
