package edu.mum.cs544.project.ecruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruit.domain.User;
import edu.mum.cs544.project.ecruit.domain.UserStatus;
import edu.mum.cs544.project.ecruit.exception.CustomGenericException;
import edu.mum.cs544.project.ecruit.repository.UserRepository;
import edu.mum.cs544.project.ecruit.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		if (user.getId() == null)
			user.setStatus(UserStatus.Active);		
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public List<User> getRegisteredUsers() {
		return userRepository.getRegisteredUsers();
	}

	public User find(Long id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			throw new CustomGenericException("User Not Found", "User with Id "
					+ id + " not found.");
		}
		return user;
	}

	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	public User findUserByLoginId(String loginId) {
		return userRepository.findUserByLoginId(loginId);
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public User changePassword(User user) {
		User newUser = find(user.getId());
		newUser.setLoginPassword(user.getLoginPassword());
		return userRepository.save(newUser);
	}

	
	public List<User> getActiveUsers(){
		return userRepository.getActiveUsers();
	}
}
