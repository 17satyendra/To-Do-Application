package com.bridgeit.toDoApp.model;

public class CollaboratorRequest {
	
	private ToDoTask todoObj ;
	private String shareEmail;

	@Override
	public String toString() {
		return "CollaboratorRequest [todoObj=" + todoObj + ", shareEmail=" + shareEmail + "]";
	}

	public ToDoTask getTodoObj() {
		return todoObj;
	}

	public void setTodoObj(ToDoTask todoObj) {
		this.todoObj = todoObj;
	}

	public String getShareEmail() {
		return shareEmail;
	}

	public void setShareEmail(String shareEmail) {
		this.shareEmail = shareEmail;
	}



}
