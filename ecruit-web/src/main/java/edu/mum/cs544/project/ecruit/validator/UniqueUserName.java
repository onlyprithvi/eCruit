package edu.mum.cs544.project.ecruit.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueUserNameValidator.class)
@Documented
public @interface UniqueUserName {
	String message() default "{unique.username.register}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}