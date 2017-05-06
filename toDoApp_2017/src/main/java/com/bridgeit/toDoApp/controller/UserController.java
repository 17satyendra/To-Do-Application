package com.bridgeit.toDoApp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeit.toDoApp.json.ErrorResponse;
import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.json.SignupErrorResponse;
import com.bridgeit.toDoApp.json.TokenResponse;
import com.bridgeit.toDoApp.json.UserResponse;
import com.bridgeit.toDoApp.model.FBProfile;
import com.bridgeit.toDoApp.model.Status;
import com.bridgeit.toDoApp.model.Token;
import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.service.UserService;
import com.bridgeit.toDoApp.validator.UserValidatation;
import com.facebook.Facebook;

/**
 * This is simple Spring MVC controller with annotations, we have added all
 * general purpose methods here those method will accept a rest request in Json
 * form and will return a JSON response. The methods are self explanatory we
 * have used @Controller annotation to point incoming requests to this class,
 * and @RequestMapping annotation to point incoming requests to appropriate
 * Methods. @RequestBody annotation is used to accept data with request in Json
 * form and @ResponseBody is used to return JSON as response to incoming
 * request.
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit Satyendra Singh.
 */
@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	private UserValidatation userValidatation;

	static final Logger logger = Logger.getLogger(UserController.class);

	/* Submit form in Spring Restful Services */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Response addUser(@RequestBody User user, BindingResult bindingResult) {
		userValidatation.validate(user, bindingResult);

		SignupErrorResponse ser = null;
		if (bindingResult.hasErrors()) {
			List<FieldError> list = bindingResult.getFieldErrors();
			ser = new SignupErrorResponse();
			ser.setStatus(-1);
			ser.setErrorlist(list);
			return ser;
		}

		try {
			userservice.addEntity(user);
			ser= new SignupErrorResponse();
			ser.setStatus(1);
			ser.setMessage("User add successfully");
			return ser;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("signUp exception", e);
			ErrorResponse er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}
	}

	/* Ger a single objct in Json form in Spring Rest Services */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Response getEmployeeById(@PathVariable("id") int id) {
		User user = null;
		ErrorResponse er = null;
		try {
			user = userservice.getEntityById(id);

		} catch (Exception e) {
			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}

		UserResponse ur = new UserResponse();
		ur.setUser(user);
		return ur;
	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Response getEmployee() {
		ErrorResponse er = null;
		List<User> userList = null;
		try {
			userList = userservice.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}

		UserResponse ur = new UserResponse();
		ur.setList(userList);
		return ur;
	}

	/* Delete an object from DB in Spring Restful Services */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteEmployee(@PathVariable("id") int id) {

		try {
			userservice.deleteEntity(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}

}
