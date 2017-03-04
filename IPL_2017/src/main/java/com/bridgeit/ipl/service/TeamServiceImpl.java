package com.bridgeit.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.ipl.dao.TeamDao;
import com.bridgeit.ipl.model.Team;
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamDao;
	@Override
	public void addTeam(Team team) {
		teamDao.addNewTeam(team);
	}
	@Override
	public List<Team> displayAllTeam() {
		List<Team> teamInfo = teamDao.displayAllTeam();

		return teamInfo;
	}
	@Override
	public List<Team> displayTeamInfo(String name) {
		List<Team> teamdetails=teamDao.displayTeamInfo(name);
		return teamdetails;
	}

}
