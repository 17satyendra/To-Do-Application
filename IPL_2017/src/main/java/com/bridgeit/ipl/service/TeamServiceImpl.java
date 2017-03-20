package com.bridgeit.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.ipl.dao.TeamDao;
import com.bridgeit.ipl.model.DreamTeam;
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
	public String getTeamName(String name) {
		String teamName=teamDao.getTeamName(name);
		return teamName;
	}
	@Override
	public Team getTeamById(long teamId) {
		return teamDao.getTeamById(teamId);
	}
	@Override
	public void addDreamTeam(DreamTeam dt) 
	{
		teamDao.addDreamTeam(dt);
	}
	
	@Override
	public DreamTeam getDreamTeamDetail(int dreamteamId) {
		return teamDao.getDreamTeamDetail(dreamteamId);
	}
	
}
