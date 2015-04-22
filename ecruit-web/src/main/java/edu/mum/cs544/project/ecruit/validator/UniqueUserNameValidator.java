package edu.mum.cs544.project.ecruit.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs544.project.ecruit.domain.User;
import edu.mum.cs544.project.ecruit.service.UserService;

public class UniqueUserNameValidator implements
		ConstraintValidator<UniqueUserName, String> {
	@Autowired
	private UserService userService;

	public void initialize(UniqueUserName constraintAnnotation) {
		// intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}


	public boolean isValid(String value, ConstraintValidatorContext context) {
		User user = userService.findUserByLoginId(value);
		if(user != null)
			return false;
		else
			return true;
	}
}