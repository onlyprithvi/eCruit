package edu.mum.cs544.project.ecruit.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.project.ecruit.domain.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{

	
	
	@Query("SELECT p FROM Profile p WHERE p.url=:url")
	Profile findProfileByURL(@Param("url") String key);
	
	@Query("SELECT p FROM Profile p")
	List<Profile> getAllProfiles(Pageable pageable);

	@Query("Select count(*) FROM Profile p")
	Long getMaxrecords();
	
	@Query("SELECT p FROM Profile p")
	List<Profile> getAllProfiles();

}
