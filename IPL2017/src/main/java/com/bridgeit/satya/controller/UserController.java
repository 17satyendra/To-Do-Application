package com.bridgeit.satya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridgeit.satya.model.User;
import com.bridgeit.satya.service.UserService;
@Controller
public class UserController
{
	@Autowired
	private UserService service;
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signUp(Model model){
		User user = new User();
		model.addAttribute("user",user);
		return "signup";
	}
	
	@RequestMapping(value="/saveData", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, BindingResult result){
		
		service.addUser(user);
		
		return "signin";
		
	}
}
