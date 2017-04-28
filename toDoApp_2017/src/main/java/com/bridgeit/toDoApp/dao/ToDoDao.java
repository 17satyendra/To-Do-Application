package com.bridgeit.toDoApp.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bridgeit.toDoApp.model.Reminder;
import com.bridgeit.toDoApp.model.ToDoTask;

public interface ToDoDao {

	void addToDoTask(ToDoTask todo) throws HibernateException;

	List<ToDoTask> getToDoListByUserId(int id) throws Exception;

	void deleteTaskByTODoId(int taskId) throws Exception;

	void addReminder(Reminder reminder);

}
