package com.bridgeit.ipl.dao;

import java.util.List;

import com.bridgeit.ipl.model.Player;

public interface PlayerDao {

	void addPlayer(Player player);

	List<Player> getAllPlayerDetails(String name);

	List<Player> displayAllPlayer(int teamId);

}
