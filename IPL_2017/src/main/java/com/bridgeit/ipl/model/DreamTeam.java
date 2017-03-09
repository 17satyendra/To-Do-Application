package com.bridgeit.ipl.model;

import java.io.Serializable;
import java.util.List;

public class DreamTeam implements Serializable
{
	private int id;
	private String dreamTeamName;
	private List<Player> list;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return dreamTeamName;
	}
	public void setName(String dreamTeamName) {
		this.dreamTeamName = dreamTeamName;
	}
	public List<Player> getList() {
		return list;
	}
	public void setList(List<Player> list) {
		this.list = list;
	}
	
}
