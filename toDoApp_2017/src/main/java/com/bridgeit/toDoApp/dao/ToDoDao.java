package com.bridgeit.toDoApp.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;

public interface ToDoDao {

	void addToDoTask(ToDoTask todo) throws HibernateException;

	List<ToDoTask> getToDoListByUserId(int id) throws Exception;
	
	List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception;

	void deleteTaskByTODoId(int taskId) throws Exception;

	void saveCollaboration(Collaboration col);

	List<ToDoTask> getSharedTodo(int id)throws Exception;

	void saveIndex(List<Map<String, Integer>> listOfIndex) throws HibernateException;

	List<User> getSharedUser(User shareBy_user) throws HibernateException;

	void deleteCollaborator(int taskId);

}
