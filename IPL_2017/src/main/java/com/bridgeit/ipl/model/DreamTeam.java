package com.bridgeit.ipl.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * This is a simple pojo or DTO class.
 * In this class DreamTeam about his information with one default constructor &
 * getter/setter 
 * with mapped database using Annotation. 
 * @author bridgeit Satyendra Singh
 * @version 1.8
 * @since 2017-03-01
 */
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
	
	@ManyToMany( fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "DreamTeam_Players", joinColumns = { @JoinColumn(name = "Team_id") }, inverseJoinColumns = { @JoinColumn(name = "player_id") })
	private List<Player> playerList;
	
	public DreamTeam() {}
	  
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
	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
}
