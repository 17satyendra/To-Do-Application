package com.bridgeit.toDoApp.service;

import java.util.List;

import com.bridgeit.toDoApp.model.User;

public interface UserService {

	void addEntity(User user) throws Exception;

	User getEntityById(int id) throws Exception;

	List<User> getEntityList() throws Exception;

	void deleteEntity(int id) throws Exception;

}
