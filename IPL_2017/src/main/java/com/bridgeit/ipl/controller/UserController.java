package com.bridgeit.ipl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.ipl.email.Mail;
import com.bridgeit.ipl.model.User;
import com.bridgeit.ipl.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@Autowired
	private Mail mail;

	@RequestMapping(value = "signup")
	public ModelAndView createUser(Model model) {
		User user = new User();
		model.addAttribute(user);
		return new ModelAndView("signup");
	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user, BindingResult result) {
		userservice.addUserINService(user);
		String senderEmail = "deepak.deepu2020@gmail.com";
		String receiverEmail = user.getEmail();
		System.out.println(receiverEmail);
		String subject="IPL2017_Registration_Confirmation[no_reply]";
		String mesg="Hi, \n this is an auto generated IPL registration E-mail confirmation,Thank you!!!";
		mail.sendMail(senderEmail, receiverEmail, subject, mesg);
		
		String message="Your data successfully saved and confiramtion mail sent to your registred E-mail.";
		return new ModelAndView("signin", "message",message);
	}
	@RequestMapping(value="/userDetails")
	public ModelAndView getUserDetail(HttpServletRequest request){
		System.out.println("Inside getUser");
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		 
		System.out.println(user.getId());
		System.out.println(user.getFirstname());
		return new ModelAndView("userDetail", "user", user);
		
		
	}
}
