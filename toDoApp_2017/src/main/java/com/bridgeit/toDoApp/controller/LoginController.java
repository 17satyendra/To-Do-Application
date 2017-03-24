package com.bridgeit.toDoApp.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.service.UserService;

/**
 * This is simple Spring MVC login controller with annotations, we have added
 * all general purpose methods here those method will accept a rest request in
 * Json form and will return a JSON response. The methods are self explanatory
 * we have used @Controller annotation to point incoming requests to this class,
 * and @RequestMapping annotation to point incoming requests to appropriate
 * Methods. @RequestBody annotation is used to accept data with request in Json
 * form and @ResponseBody is used to return JSON as response to incoming
 * request.
 * 
 * @version 1.8jdk
 * @since 2017-03-23.
 * @author bridgeit Satyendra Singh.
 */
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserService userservice;

	static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User getEmployeeById(@RequestBody Map<String, String> loginMap) {
		User user = null;
		try {
			user = userservice.authUser(loginMap.get("email"), loginMap.get("password"));
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("login exception", e);
		}
		return user;
	}
}
