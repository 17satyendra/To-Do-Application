package com.bridgeit.ipl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.ipl.dao.UserDao;
import com.bridgeit.ipl.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public void addUserINService(User user) {
		userdao.addUserINDao(user);
	}

	@Override
	public User authUser(String email, String password) {
		return userdao.authUser(email, password);
	}

}
