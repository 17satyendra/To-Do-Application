package com.bridgeit.toDoApp.service;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;

public interface ToDoService {

	void addToDoTask(ToDoTask todo) throws HibernateException;

	List<ToDoTask> getToDoList(int id)throws Exception;
	
	List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception; 

	void deleteTaskByToDoId(int taskId)throws Exception;

	void saveCollaboration(Collaboration col);

	void updateIndex(List<Map<String, Integer>> listOfIndex) throws HibernateException;

	List<User> getSharedUserList(User shareBy_user);

}
