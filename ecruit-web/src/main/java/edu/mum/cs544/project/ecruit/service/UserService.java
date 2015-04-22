package edu.mum.cs544.project.ecruit.service;

import java.util.List;

import edu.mum.cs544.project.ecruit.domain.User;

public interface UserService {

	User saveUser(User user);

	List<User> findAll();

	List<User> getRegisteredUsers();

	User find(Long id);
	
	User findUserByLoginId(String loginId);	
	
	User findUserByEmail(String email);

	User changePassword(User user);

	void deleteUser(long id);	
	
	List<User> getActiveUsers();
	
}
