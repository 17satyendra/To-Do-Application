package com.bridgeit.toDoApp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.model.User;
//import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.service.ToDoService;
import com.bridgeit.toDoApp.service.UserService;

@Controller
public class CollaboratorController {
	
	
	@Autowired
	private ToDoService toDoService;
	
	@Autowired
	private UserService userservice;
	
	static final Logger logger = Logger.getLogger(CollaboratorController.class);
	
	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public @ResponseBody Response addTask(@RequestBody Map<String, String> shareMap ) {
		
		User user=userservice.getEntityByEmailId(shareMap.get("sharedEmail"));
		System.out.println(user);
		Collaboration col = new Collaboration();
		col.setShared_User(user);
		System.out.println("fdgfd sdfsdjo");
		
		return null;
		
	}
}
