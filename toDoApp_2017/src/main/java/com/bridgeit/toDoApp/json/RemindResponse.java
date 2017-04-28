package com.bridgeit.toDoApp.json;

import com.bridgeit.toDoApp.model.Reminder;

public class RemindResponse extends Response{

	private Reminder remind;

	public Reminder getRemind() {
		return remind;
	}

	public void setRemind(Reminder remind) {
		this.remind = remind;
	}
}
