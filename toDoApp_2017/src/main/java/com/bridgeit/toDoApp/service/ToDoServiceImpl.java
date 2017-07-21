package com.bridgeit.toDoApp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.toDoApp.controller.UserController;
import com.bridgeit.toDoApp.dao.ToDoDao;
import com.bridgeit.toDoApp.json.ErrorResponse;
import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.json.TaskResponse;
import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;

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
	
	static final Logger logger = Logger.getLogger(ToDoServiceImpl.class);
	
	public void addToDoTask(ToDoTask todo) throws HibernateException {
		tododao.addToDoTask(todo);
	}
	

	public List<ToDoTask> getToDoList(int userId) throws Exception {
		List<ToDoTask> todoList= tododao.getToDoListByUserId(userId);
		
		List<ToDoTask> shareTodo = tododao.getSharedTodo(userId );
		if(shareTodo!=null){
			todoList.addAll(shareTodo);
		}
		return todoList;
	}
	@Transactional
	public void deleteTaskByToDoId(int taskId) throws Exception {
		tododao.deleteCollaborator(taskId);
		tododao.deleteTaskByTODoId(taskId);
		
	}

	@Override
	public List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception {
		return tododao.getArchivedTOdoTask(userId);
	}

	@Override
	public void saveCollaboration(Collaboration col) {
		tododao.saveCollaboration(col);
		
		
	}


	@Override
	public void updateIndex(List<Map<String, Integer>> listOfIndex) throws HibernateException {
		tododao.saveIndex(listOfIndex);
		
	}


	@Override
	public List<User> getSharedUserList(User shareBy_user) {
		
		return tododao.getSharedUser( shareBy_user );
	}

}
