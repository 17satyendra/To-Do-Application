package com.bridgeit.toDoApp.dao;

import java.util.List;

import com.bridgeit.toDoApp.model.User;

public interface UserDao {

	void addEntity(User user) throws Exception;

	User getEntityById(int id) throws Exception;

	List<User> getUserList() throws Exception;

	void deleteEntity(int id) throws Exception;

}
