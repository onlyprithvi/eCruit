package edu.mum.cs544.project.ecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.project.ecruit.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findUserByLoginId(@Param("username") String key);

	@Query("SELECT u FROM User u WHERE u.email=:email")
	User findUserByEmail(@Param("email") String key);

	@Query("SELECT u FROM User u WHERE u.role=1")
	List<User> getRegisteredUsers();
	
	@Query("SELECT u FROM User u WHERE u.status=1 and u.role=1")
	List<User> getActiveUsers();

	
}
