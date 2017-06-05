package com.bridgeit.toDoApp.dao;

import java.io.InputStream;
import java.util.List;

import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.model.UserPicture;

public interface UserDao {

	void addEntity(User user) throws Exception;

	User getEntityById(int id) throws Exception;

	List<User> getUserList() throws Exception;

	void deleteEntity(int id) throws Exception;

	User authUser(String email, String password);

	User getEntityByEmailId(String email);
	
	void savePicture(UserPicture picture);
	UserPicture getPicture(int userId);

}
