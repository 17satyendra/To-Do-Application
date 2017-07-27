package com.bridgeit.toDoApp.json;

import com.bridgeit.toDoApp.model.User;

public class CollaborationResponse extends Response{
	private User share;

	public User getShare() {
		return share;
	}

	public void setShare(User share) {
		this.share = share;
	}
}
