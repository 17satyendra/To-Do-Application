package com.bridgeit.ipl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.ipl.model.Player;
@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public void addPlayer(Player player) {
		System.out.println("inside doa method");
		Session session = sessionfactory.getCurrentSession();
		session.save(player);

	}

	@Override
	public List<Player> getAllPlayerDetails(String name) {
		Session session = sessionfactory.getCurrentSession();
		Query qry = session.createQuery("from Player where name=:playerName");
		qry.setParameter("playerName", name);
		List<Player> playerDetails = qry.list();
		return playerDetails;
	}

	@Override
	public List<Player> displayAllPlayer(int teamId) {
		Session session = sessionfactory.getCurrentSession();
		Query qry = session.createQuery("from Player where teamId=:id");
		qry.setParameter("id", teamId);
		List<Player> playersInfo = qry.list();
		return playersInfo;
	}

}
