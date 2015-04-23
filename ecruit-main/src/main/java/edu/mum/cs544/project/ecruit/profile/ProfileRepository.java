package edu.mum.cs544.project.ecruit.profile;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public interface ProfileRepository extends CrudRepository<Profile, Long>{

	@Query("SELECT p FROM Profile p")
	List<Profile> getAllProfiles();
	
	
	
	@Query("SELECT p FROM Profile p WHERE p.url=:url")
	Profile findProfileByURL(@Param("url") String key);

}
