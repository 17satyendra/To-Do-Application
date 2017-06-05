package com.bridgeit.toDoApp.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.toDoApp.dao.UserDao;
import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.model.UserPicture;

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

	
	public void addEntity(User user) throws Exception {
		dao.addEntity(user);

	}

	
	public User getEntityById(int id) throws Exception{
		return dao.getEntityById(id);
	}


	public List<User> getEntityList() throws Exception {
		return dao.getUserList();
	}

	
	public void deleteEntity(int id) throws Exception {
		dao.deleteEntity(id);
	}

	
	public User authUser(String email, String password) {
		return dao.authUser(email, password);
	}

	public User getEntityByEmailId(String email) {
		return dao.getEntityByEmailId(email);
	}


	@Override
	public void savePicture(UserPicture picture){
		dao.savePicture(picture);
		
	}

	public UserPicture getPicture(int userId)
	{
		return dao.getPicture(userId);
	}
}
