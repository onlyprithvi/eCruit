package edu.mum.cs544.project.ecruit.service;

import java.util.List;

import edu.mum.cs544.project.ecruit.domain.Profile;
import edu.mum.cs544.project.ecruit.domain.UserInputFilter;

public interface ProfileService {

	public void save(String url, String name, String industry,
			List<String> skills, List<String> education, int experience);

	public List<Profile> getAllProfiles(int page, int pageSize);
	
	public List<Profile> getAllProfiles();


	public Long getMaxPage(int pageSize);

	public Profile getProfile(String url);

}
