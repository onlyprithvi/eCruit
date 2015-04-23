package edu.mum.cs544.project.ecruit.util;

import org.springframework.security.core.context.SecurityContextHolder;

import edu.mum.cs544.project.ecruit.domain.User;

public class SecurityUtil {

	public static User getSessionUser() {
		User user;
		try{
		user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		}catch(Exception ex){
			user=null;
		}
		return user;
	}

}
