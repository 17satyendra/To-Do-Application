package com.bridgeit.toDoApp.model;

/**
 * This is Status POJO to represent conditional Status and Error messages for
 * toDoApplication in form of Json, this comes handy in case of sending status
 * response to requests if needed.
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit Satyendra Singh. .
 */
public class Status {
	private int code;
	private String message;

	public Status() {
	}

	public Status(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
