package edu.mum.cs544.project.ecruit.profile;

import java.util.List;

public interface ProfileService {
	
	public void save(String url, String name, String industry,
			List<String> skills, List<String> education, int experience);

	public List<Profile> getAllProfiles();

	public Profile getProfile(String url);
}
