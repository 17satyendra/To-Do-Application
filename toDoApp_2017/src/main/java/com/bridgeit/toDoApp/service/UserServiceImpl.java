package com.bridgeit.toDoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.toDoApp.dao.UserDao;
import com.bridgeit.toDoApp.model.User;

/**
 * A service layer does nothing but it makes the code more flexible and
 * reusable, using an Service layer in your projects makes it easy to test the
 * data layer.We are using @Autowired UserDao dao to pass the appropriate method
 * to UserDaoImpl layer for further database operation.
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit Satyendra Singh.
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public void addEntity(User user) throws Exception {
		dao.addEntity(user);

	}

	@Override
	public User getEntityById(int id) throws Exception{
		return dao.getEntityById(id);
	}

	@Override
	public List<User> getEntityList() throws Exception {
		return dao.getUserList();
	}

	@Override
	public void deleteEntity(int id) throws Exception {
		dao.deleteEntity(id);
	}

}
