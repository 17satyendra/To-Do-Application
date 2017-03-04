package com.bridgeit.ipl.dao;

import java.util.List;

import com.bridgeit.ipl.model.Team;

public interface TeamDao {

	void addNewTeam(Team team);

	List<Team> displayAllTeam();

	List<Team> displayTeamInfo(String name);

}
