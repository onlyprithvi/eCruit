package edu.mum.cs544.project.ecruit.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruit.domain.Role;
import edu.mum.cs544.project.ecruit.domain.User;
import edu.mum.cs544.project.ecruit.service.UserService;

@Service
@Qualifier("customUserDetailService")
@Transactional(readOnly = true)
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	UserService userService;

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		User user = userService.findUserByLoginId(login);		
		user.setAuthorities(getAuthorities(user.getRole()));
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Role role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}	

	
	// fetch roles from user groups
	public List<String> getRoles(Role role) {
		List<String> roles = new ArrayList<String>();
		if (role == Role.Admin) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");
		} else if (role == Role.User) {
			roles.add("ROLE_USER");
		}
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
	
}

