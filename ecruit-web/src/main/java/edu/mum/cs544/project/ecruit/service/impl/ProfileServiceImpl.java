package edu.mum.cs544.project.ecruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.project.ecruit.repository.ProfileRepository;
import edu.mum.cs544.project.ecruit.service.ProfileService;
import edu.mum.cs544.project.ecruiter.domain.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository repository;
	
	public List<Profile> getAllProfiles() {
		return repository.getAllProfiles();
	}

}
