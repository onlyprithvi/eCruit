package edu.mum.cs544.project.ecruit.service;

import java.util.List;

import edu.mum.cs544.project.ecruit.domain.Profile;

public interface ProfileService {
	
	public void save(String url, String name, String industry,
			List<String> skills, List<String> education, int experience);

	public List<Profile> getAllProfiles();

	public Profile getProfile(String url);
}
