package com.bridgeit.toDoApp.json;

import java.util.List;

import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;

public class TaskResponse extends Response {

	private ToDoTask doTask;
	private List<User> sharedUser;
	private List<ToDoTask> list;

	public ToDoTask getDoTask() {
		return doTask;
	}

	public void setDoTask(ToDoTask doTask) {
		this.doTask = doTask;
	}

	public List<ToDoTask> getList() {
		return list;
	}

	public void setList(List<ToDoTask> list) {
		this.list = list;
	}

	public List<User> getSharedUser() {
		return sharedUser;
	}

	public void setSharedUser(List<User> sharedUser) {
		this.sharedUser = sharedUser;
	}

	@Override
	public String toString() {
		return "TaskResponse [doTask=" + doTask + ", sharedUser=" + sharedUser + ", list=" + list + "]";
	}
	
}
