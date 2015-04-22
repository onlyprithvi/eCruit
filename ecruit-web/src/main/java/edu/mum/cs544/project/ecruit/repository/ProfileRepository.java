package edu.mum.cs544.project.ecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.project.ecruiter.domain.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{

	@Query("SELECT p FROM Profile p")
	List<Profile> getAllProfiles();
}
