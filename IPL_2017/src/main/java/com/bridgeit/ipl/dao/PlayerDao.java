package com.bridgeit.ipl.dao;

import java.util.List;

import com.bridgeit.ipl.model.Player;

public interface PlayerDao {

	void addPlayer(Player player);

	Player getPlayerDetails(Long playerId);

	List<Player> displayAllPlayer(int teamId);
	
	List<Player> displayAllPlayer();

	Player getPlayer(String playerName);

	List<Player> getPlayerList(String[] player);

	int updateView(int view, Long playerId);
	
}
