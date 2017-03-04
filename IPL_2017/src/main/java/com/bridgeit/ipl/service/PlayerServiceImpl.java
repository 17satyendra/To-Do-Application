package com.bridgeit.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.ipl.dao.PlayerDao;
import com.bridgeit.ipl.model.Player;
@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerDao playerdao;
	@Override
	public void addPlayer(Player player) {
		
		playerdao.addPlayer(player);
		
	}
	@Override
	public List<Player> getAllPlayerDetails(String name) {
		List<Player> playerDetails = playerdao.getAllPlayerDetails(name);
		return playerDetails;
	}
	@Override
	public List<Player> displayAllPlayer(int teamId) {
		List<Player> playerList = playerdao.displayAllPlayer(teamId);
		return playerList;
	}

}
