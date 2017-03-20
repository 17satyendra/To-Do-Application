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
	public Player getPlayerDetails(Long playerId) {
		Player playerDetails = playerdao.getPlayerDetails(playerId);
		return playerDetails;
	}
	@Override
	public List<Player> displayAllPlayer(int teamId) {
		List<Player> playerList = playerdao.displayAllPlayer(teamId);
		return playerList;
	}
	@Override
	public List<Player> displayAllPlayer() {
		List<Player> playerList = playerdao.displayAllPlayer();
		return playerList;
	}
	@Override
	public Player getPlayer(String playerName) {
		return playerdao.getPlayer(playerName);
	}
	@Override
	public List<Player> getPlayerList(String[] player) {
		return playerdao.getPlayerList(player);
	}
	@Override
	public int viewUpdate(int view, Long playerId) {
		return playerdao.updateView(view, playerId);
	}
	@Override
	public List<Player> getDreamPlayerList(int dreamId) {
		
		return playerdao.getDreamPlayerList(dreamId);
	}

}
