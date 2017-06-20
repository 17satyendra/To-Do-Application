package com.bridgeit.toDoApp.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bridgeit.toDoApp.model.ToDoTask;

public interface ToDoDao {

	void addToDoTask(ToDoTask todo) throws HibernateException;

	List<ToDoTask> getToDoListByUserId(int id) throws Exception;
	
	List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception;

	void deleteTaskByTODoId(int taskId) throws Exception;

}
