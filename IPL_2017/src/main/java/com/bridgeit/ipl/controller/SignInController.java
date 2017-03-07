package com.bridgeit.ipl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bridgeit.ipl.model.User;
import com.bridgeit.ipl.service.UserService;

@Controller
@RequestMapping("/")
public class SignInController {

	@Autowired
	private UserService userservice;
	
	private Logger logger = Logger.getLogger(SignInController.class);

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

	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public String signin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request) {
		System.out.println(email + " " + password);
		User user = userservice.authUser(email, password);
		System.out.println(user);
		if (user == null) {
			return "failure";
		} else {
				
				HttpSession sesion = request.getSession();
				sesion.invalidate(); // invalidate existing session
				logger.debug(sesion);
				// creating new session
				sesion = request.getSession();
				sesion.setAttribute("user", user);
				// Maximum active time
				sesion.setMaxInactiveInterval(1000);
				
				//model.addAttribute("userName", userName);
				return "redirect:/teamList";
		}
	}

	@RequestMapping(value = "signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		sesion = request.getSession();
		return "/signin";
	}

}
