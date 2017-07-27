package com.bridgeit.toDoApp.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeit.toDoApp.json.ErrorResponse;
import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.json.TaskResponse;
import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.service.ToDoService;

/**
 * This is simple Spring MVC Rest ToDo controller with annotations, we have
 * added all general purpose methods here those method will accept a rest
 * request in Json form and will return a JSON response. The methods are self
 * explanatory we have used @Controller annotation to point incoming requests to
 * this class, and @RequestMapping annotation to point incoming requests to
 * appropriate Methods. @RequestBody annotation is used to accept data with
 * request in Json form and @ResponseBody is used to return JSON as response to
 * incoming request.
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit Satyendra Singh.
 *
 */
@Controller
@RequestMapping("/")

public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	static final Logger logger = Logger.getLogger(UserController.class);

	/**
	 * In this method we pass the json object for todotask and add to database.
	 * 
	 * @param todo
	 *            Request Body from User in json object.
	 * @return Response Json object Status and Message
	 */
	@RequestMapping(value = "/createtask", method = RequestMethod.POST)
	public @ResponseBody Response addTask(@RequestBody ToDoTask todo, HttpServletRequest request) {

		ErrorResponse er = null;
		TaskResponse tr = null;
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		todo.setUser(user);
		todo.setDate(new Date());
		try {

			toDoService.addToDoTask(todo);
			tr = new TaskResponse();
			tr.setDoTask(todo);
			tr.setStatus(1);
			tr.setMessage("Task added successfully");
			return tr;
		} catch (Exception e) {
			logger.error("ToDoTask Add exception", e);
			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}
	}

	@RequestMapping(value = "/todoList")
	public @ResponseBody Response getToDoList(HttpServletRequest request) {

		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		ErrorResponse er = null;
		List<ToDoTask> toDoList = null;
		List<User> sharedUser=null;
		try {
			toDoList = toDoService.getToDoList(user.getId());
			Collections.sort(toDoList, new Comparator<ToDoTask>() {
				@Override
				public int compare(ToDoTask o1, ToDoTask o2) {
					return Integer.valueOf(o1.getCardIndex()).compareTo( o2.getCardIndex() ) ;
				}
			});
			for(int i = 0; i< toDoList.size(); i++){
				ToDoTask todo=toDoList.get(i);
				sharedUser = toDoService.getSharedUserList(todo);
				todo.setSharedUser(sharedUser);
			}
			//sharedUser = toDoService.getSharedUserList(user);
			TaskResponse tr = new TaskResponse();
			tr.setStatus(1);
			tr.setMessage("Data fetched sccessfully");
			tr.setList(toDoList);
			return tr;
		} catch (Exception e) {
			e.printStackTrace();
			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}
	}

	@RequestMapping(value = "dynamicList/{opt}")
	public @ResponseBody Response getArchivedTodo(@PathVariable("opt") int option, HttpServletRequest request) {
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		ErrorResponse er = null;
		List<ToDoTask> toDoList;
		try {
			toDoList = toDoService.getDynamicList(user.getId(), option);
			
			TaskResponse tr=new TaskResponse();
			tr.setStatus(1);
			tr.setMessage("List fetched sccessfully");
			tr.setList(toDoList);

			return tr;
		} catch (Exception e) {
			e.printStackTrace();

			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");

			return er;
		}
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public @ResponseBody Response deleteTask(@PathVariable("id") int taskId) {
		Response res = null;
		ErrorResponse er = null;
		try {
			toDoService.deleteTaskByToDoId(taskId);
			res = new Response();
			res.setStatus(1);
			res.setMessage("data delete scuessfully");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again");
			return er;
		}
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public @ResponseBody Response updateTask(@RequestBody ToDoTask todo, @PathVariable("id") int taskId,
			HttpServletRequest request) {

		ErrorResponse er = null;
		TaskResponse tr = null;
		
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");

		todo.setUser(user);
		todo.setId(taskId);
		todo.setDate(new Date());

		try {
			toDoService.addToDoTask(todo);
			tr = new TaskResponse();
			tr.setDoTask(todo);
			tr.setStatus(1);
			tr.setMessage("Task updated successfully");
			
			return tr;
		} catch (Exception e) {
			// logger.error("ToDoTask update exception", e);
			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			
			return er;
		}
	}
	@RequestMapping(value = "saveIndex", method = RequestMethod.POST)
	public @ResponseBody Response saveIndex(@RequestBody List<Map<String, Integer>> listOfIndex){
		Response resp=null;
		try{
			toDoService.updateIndex(listOfIndex);
			resp.setMessage("index updated successfully");
			resp.setStatus(1);
			return resp;
		}catch (Exception e) {
			logger.error(e.getMessage());
			
			ErrorResponse err= new ErrorResponse();
			err.setStatus(-1);
			err.setMessage(e.getMessage()+" index not Updated please try again");
			
			return err;
		}
		
	}
	
}
