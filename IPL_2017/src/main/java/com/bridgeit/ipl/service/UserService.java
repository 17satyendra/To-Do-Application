package com.bridgeit.ipl.service;

import com.bridgeit.ipl.model.DreamTeam;
import com.bridgeit.ipl.model.User;

public interface UserService {
	void addUserINService(User user);

	User authUser(String email, String password);

	boolean ispresentTeam(int id);
	
	DreamTeam getDreamTeam(int id);

}
