package com.bridgeit.toDoApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeit.toDoApp.json.ProfileResponse;
import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.model.User;
@Controller
public class ProfileController {
	
	@RequestMapping(value="getProfile")
	public @ResponseBody Response getUser(HttpServletRequest request){
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		
		ProfileResponse pr = new ProfileResponse();
		pr.setId(user.getId());
		pr.setFirstName(user.getFirstName());
		pr.setLastName(user.getLastName());
		pr.setEmail(user.getEmail());
		pr.setMobile(user.getMobileNumber());
		pr.setPicture(user.getPicture());
		
		return pr;
		
	}

}
