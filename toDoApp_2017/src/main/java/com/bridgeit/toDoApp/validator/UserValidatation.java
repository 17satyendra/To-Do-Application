package com.bridgeit.toDoApp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bridgeit.toDoApp.model.User;

/**
 * Everything related to User Resistration validation in spring goes here. This
 * is a simple java class and make it implement a pre defined interface so
 * called 'Validator'. There are two methods in validator interface override
 * them in your own class and write validation code in validate() method.
 * 
 * @version 1.8jdk
 * @since 2017-03-23.
 * @author bridgeit Satyendra Singh.
 *
 */
public class UserValidatation implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	String STRING_PATTERN = "[a-zA-Z]+";
	String MOBILE_PATTERN = "[0-9]{10}";
	// String ID_PATTERN = "[0-9]+";

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		/*
		 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",
		 * "required.id", "Id is required.");
		 * 
		 * // input string conatains numeric values only if (user.getId() !=
		 * null) { pattern = Pattern.compile(ID_PATTERN); matcher =
		 * pattern.matcher(student.getId().toString()); if (!matcher.matches())
		 * { errors.rejectValue("id", "id.incorrect", "Enter a numeric value");
		 * }
		 * 
		 * // input string can not exceed that a limit if
		 * (User.getId().toString().length() > 5) { errors.rejectValue("id",
		 * "id.exceed", "Id should not contain more than 5 digits"); } }
		 */

		ValidationUtils.rejectIfEmpty(errors, "firstName", "required.firstName", "First Name is required.");

		// input string conatains characters only
		if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if (!matcher.matches()) {
				errors.rejectValue("firstName", "firstName.containNonChar", "Enter a valid Firstname");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "lastName", "required.lastName", "Last Name is required.");

		if (!(user.getLastName() != null && user.getLastName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if (!matcher.matches()) {
				errors.rejectValue("lastName", "lastName.containNonChar", "Enter a valid Lastname");
			}
		}

		// email validation in spring
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required.");

		if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect", "Enter a correct email");
			}
		}

		// phone number validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "required.phone", "Mobile Number is required.");

		if (!(user.getMobileNumber() != null && user.getMobileNumber().isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(user.getMobileNumber());
			if (!matcher.matches()) {
				errors.rejectValue("mobile", "mobile.incorrect", "Enter a correct Mobile number");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password is required.");

		// password matching validation
		/*if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "password.mismatch", "Password does not match");
		}
*/
	}

}
