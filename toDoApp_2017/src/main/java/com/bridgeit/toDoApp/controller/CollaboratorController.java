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
import com.bridgeit.toDoApp.model.CollaboratorRequest;
import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;
//import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.service.ToDoService;
import com.bridgeit.toDoApp.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class CollaboratorController {
	
	
	@Autowired
	private ToDoService toDoService;
	
	@Autowired
	private UserService userservice;
	
	static final Logger logger = Logger.getLogger(CollaboratorController.class);
	
	static Response resp=null;
	
	@RequestMapping(value = "share", method = RequestMethod.POST)
	public @ResponseBody Response addTask(@RequestBody CollaboratorRequest cr) {
		
		System.out.println(cr);
		
		User user=userservice.getEntityByEmailId(cr.getShareEmail());
		System.out.println(user);
		if(user==null){
			resp=new Response();
			resp.setMessage("Invalid User email");
			resp.setStatus(0);
			return resp;
		}
		Collaboration col = new Collaboration();  
		col.setShared_User(user);
		col.setTodo(cr.getTodoObj());
		
		toDoService.saveCollaboration(col);
		Response resp = new Response();
		resp.setMessage("done");
		resp.setStatus(1);
		return resp;
	
	}
}
