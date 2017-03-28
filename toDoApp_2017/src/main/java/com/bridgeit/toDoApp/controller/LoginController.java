package com.bridgeit.toDoApp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeit.toDoApp.json.ErrorResponse;
import com.bridgeit.toDoApp.json.LoginResponse;
import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.json.TokenResponse;
import com.bridgeit.toDoApp.model.Token;
import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.service.TokenService;
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
	
	@Autowired
	private TokenService tokenservice;

	static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Response getEmployeeById(@RequestBody Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) {
		User user = null;
		String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
		String refreshToken = UUID.randomUUID().toString().replaceAll("-", "");

		HttpSession session = request.getSession();
		try {
			user = userservice.authUser(loginMap.get("email"), loginMap.get("password"));
			
		} catch (Exception e) {
			log.error("login exception", e);
			ErrorResponse er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}

		if (user == null) {

			ErrorResponse er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Invalid credential, Please check email or password");
			return er;
		}
		Token token = new Token();
		token.setCreatedOn(new Date());
		token.setAccessToken(accessToken);
		token.setRefreshToken(refreshToken);
		token.setId(user.getId());
		tokenservice.addToken(token);
		//session.setAttribute("user", user);
		LoginResponse lr = new LoginResponse();
		lr.setStatus(1);
		lr.setMessage("User logged succesfully");
		TokenResponse tr = new TokenResponse();
		tr.getAccessToken();
		tr.getRefreshToken();
		tr.setStatus(1);

		Cookie ck = new Cookie("access_token", token.getAccessToken());
		response.addCookie(ck);
		System.out.println(ck.getValue());
		return tr;
	}
}
