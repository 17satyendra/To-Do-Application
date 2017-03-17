package com.bridgeit.ipl.dao;

import com.bridgeit.ipl.model.User;

public interface UserDao {

	void addUserINDao(User user);

	User authUser(String email, String password);

	boolean isPresentId(int id);

}
