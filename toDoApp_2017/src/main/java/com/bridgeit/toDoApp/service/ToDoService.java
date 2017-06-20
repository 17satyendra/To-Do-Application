package com.bridgeit.toDoApp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;

import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.model.ToDoTask;

public interface ToDoService {

	void addToDoTask(ToDoTask todo) throws HibernateException;

	Response getToDoList(HttpServletRequest request);
	
	List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception; 

	void deleteTaskByToDoId(int taskId)throws Exception;

}
