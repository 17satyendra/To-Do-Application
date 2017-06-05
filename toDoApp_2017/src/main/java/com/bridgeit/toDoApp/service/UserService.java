package com.bridgeit.toDoApp.service;

import java.io.InputStream;
import java.util.List;

import com.bridgeit.toDoApp.model.User;
import com.bridgeit.toDoApp.model.UserPicture;

public interface UserService {

	void addEntity(User user) throws Exception;

	User getEntityById(int id) throws Exception;

	List<User> getEntityList() throws Exception;

	void deleteEntity(int id) throws Exception;

	User authUser(String email, String password);

	User getEntityByEmailId(String email);

	public void savePicture(UserPicture pUserPicture);
	UserPicture getPicture(int userId);

}
