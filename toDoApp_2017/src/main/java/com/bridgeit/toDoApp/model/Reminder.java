package com.bridgeit.toDoApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is simple POJO to represent Reminder entity in our application, we will
 * be dealing with Reminder entity to save remainder for perticular todo task
 * for today, tomorrow and next Week with specific Date and time , retrieve and
 * delete data using Spring Restful Web Services. We have annotated the class
 * with Hibernate annotations to make hibernate aware of the entity.
 * 
 * @version 1.8Jdk
 * @since 2017-04-28.
 * @author bridgeit Satyendra Singh.
 *
 */
@Entity
@Table
public class Reminder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "any", strategy = "increment")
	@GeneratedValue(generator = "any")
	private int id;
	private String day;
	private Date date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_Id")
	private ToDoTask task;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ToDoTask getTask() {
		return task;
	}

	public void setTask(ToDoTask task) {
		this.task = task;
	}
}
