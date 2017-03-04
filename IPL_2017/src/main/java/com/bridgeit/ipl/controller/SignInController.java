package com.bridgeit.ipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.ipl.model.User;
import com.bridgeit.ipl.service.UserService;
@Controller
@RequestMapping("/")
public class SignInController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}

	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}

	@RequestMapping(value = "signin", method = RequestMethod.GET)
	public String init() {
		return "signin";
	}
	@RequestMapping(value="signin", method=RequestMethod.POST)
	public ModelAndView signin(@RequestParam("email") String email, @RequestParam("password")String password,
			Model model){
		System.out.println(email+" "+password);
		User user = userservice.authUser(email, password);
		System.out.println(user);
		if (user==null)
		{
			return new ModelAndView("failure");
		}else{
			return new ModelAndView("ipl_info");
		}
	}
}
