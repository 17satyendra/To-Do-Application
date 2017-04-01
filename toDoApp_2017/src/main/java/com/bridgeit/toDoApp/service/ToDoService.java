package com.bridgeit.toDoApp.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.bridgeit.toDoApp.model.ToDoTask;

public interface ToDoService {

	void addToDoTask(ToDoTask todo) throws HibernateException;

	List<ToDoTask> getToDoList(int id)throws Exception;

}
