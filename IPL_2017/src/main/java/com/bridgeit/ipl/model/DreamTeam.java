package com.bridgeit.ipl.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="DreamTeam_Details")
public class DreamTeam implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="Team_id")
	private int id;
	@Column(name="Team_Name")
	private String dreamTeamName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_Id")
	private User user;
	  private int userId;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDreamTeamName() {
		return dreamTeamName;
	}
	public void setDreamTeamName(String dreamTeamName) {
		this.dreamTeamName = dreamTeamName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
