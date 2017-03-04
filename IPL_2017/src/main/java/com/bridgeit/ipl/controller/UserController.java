package com.bridgeit.ipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.ipl.model.User;
import com.bridgeit.ipl.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "signup")
	public ModelAndView createUser(Model model) {
		User user = new User();
		model.addAttribute(user);
		return new ModelAndView("signup");
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user, BindingResult result) {
		userservice.addUserINService(user);
		return new ModelAndView("signin");
	}
}
