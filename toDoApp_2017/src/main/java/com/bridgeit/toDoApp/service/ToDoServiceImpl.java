package com.bridgeit.toDoApp.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.toDoApp.dao.ToDoDao;
import com.bridgeit.toDoApp.model.ToDoTask;

/**
 *A service layer does nothing but it makes the code more flexible and
 * reusable, using an Service layer in your projects makes it easy to test the
 * data layer.We are using @Autowired ToDoDao to pass the appropriate method
 * to ToDoDaoImpl layer for further database operation.
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit Satyendra Singh.
 */
@Service

public class ToDoServiceImpl implements ToDoService{

	@Autowired
	private ToDoDao tododao;
	
	@Override
	public void addToDoTask(ToDoTask todo) throws HibernateException {
		tododao.addToDoTask(todo);
	}

	@Override
	public List<ToDoTask> getToDoList(int id) throws Exception {
		return tododao.getToDoListByUserId(id);
	}

	@Override
	public void deleteTaskByToDoId(int taskId) throws Exception {
		tododao.deleteTaskByTODoId(taskId);
	}

}
