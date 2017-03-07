package com.bridgeit.ipl.model;

import java.util.List;

public class DreamTeam 
{
	private int id;
	private String name;
	private List<Player> list;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Player> getList() {
		return list;
	}
	public void setList(List<Player> list) {
		this.list = list;
	}
	
}
