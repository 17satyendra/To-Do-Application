package com.bridgeit.toDoApp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.toDoApp.controller.UserController;
import com.bridgeit.toDoApp.dao.ToDoDao;
import com.bridgeit.toDoApp.json.ErrorResponse;
import com.bridgeit.toDoApp.json.Response;
import com.bridgeit.toDoApp.json.TaskResponse;
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

	public Response getToDoList(HttpServletRequest request) {
		
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		ErrorResponse er = null;
		Response resp=null;
		List<ToDoTask> toDoList;
		try{
			toDoList=tododao.getToDoListByUserId( user.getId() );
			if(toDoList==null){
				logger.setLevel(Level.WARN);
				logger.warn("list null, No task yet created");
				resp= new Response();
				
			}
			logger.info("List of note fetched+");
			TaskResponse tr = new TaskResponse();
			tr.setStatus(1);
			tr.setMessage("Data fetched sccessfully");
			tr.setList(toDoList);
			return tr;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Internal server error, please try again.");
			return er;
		}
	}

	public void deleteTaskByToDoId(int taskId) throws Exception {
		tododao.deleteTaskByTODoId(taskId);
	}

	@Override
	public List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception {
		return tododao.getArchivedTOdoTask(userId);
	}

}
