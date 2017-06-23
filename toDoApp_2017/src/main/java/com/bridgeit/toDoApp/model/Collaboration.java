package com.bridgeit.toDoApp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Collaboration implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="any", strategy="increment")
	@GeneratedValue(generator="any")
	private int coll_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private ToDoTask todo;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private User shared_User;
	
	
	public int getColl_id() {
		return coll_id;
	}
	public void setColl_id(int coll_id) {
		this.coll_id = coll_id;
	}
	public ToDoTask getTodo() {
		return todo;
	}
	public void setTodo(ToDoTask todo) {
		this.todo = todo;
	}
	public User getShared_User() {
		return shared_User;
	}
	public void setShared_User(User shared_User) {
		this.shared_User = shared_User;
	}
	@Override
	public String toString() {
		return "Collaboration [coll_id=" + coll_id + ", todo=" + todo + ", shared_User=" + shared_User + "]";
	}
	
	
}
