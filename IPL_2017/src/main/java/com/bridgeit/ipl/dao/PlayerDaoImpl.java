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
		Session session = sessionfactory.getCurrentSession();
		try {
			session.save(player);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Player getPlayerDetails(Long playerId) {
		Session session = sessionfactory.getCurrentSession();
		Query qry = session.createQuery("from Player where id=:playerId");
		qry.setParameter("playerId", playerId);
		Player playerDetails = (Player) qry.uniqueResult();
		return playerDetails;
	}

	@Override
	public List<Player> displayAllPlayer(int teamId) {
		Session session = sessionfactory.getCurrentSession();
		Query qry = session.createQuery("from Player where teamId=:id");
		qry.setParameter("id", teamId);
		@SuppressWarnings("unchecked")
		List<Player> playersInfo = qry.list();
		return playersInfo;
	}

	@Override
	public List<Player> displayAllPlayer() {
		Session session = sessionfactory.getCurrentSession();
		Query qry = session.createQuery("from Player");
		@SuppressWarnings("unchecked")
		List<Player> playersInfo = qry.list();
		return playersInfo;
	}

	@Override
	public Player getPlayer(String playerName) {
		Session session = sessionfactory.getCurrentSession();
		Query qry = session.createQuery("from Player where name=:name");
		qry.setParameter("name", playerName);
		Player player = (Player) qry.uniqueResult();
		return player;
	}

	@Override
	public List<Player> getPlayerList(String[] player) {
		Session session = sessionfactory.getCurrentSession();
		Query q = session.createQuery("SELECT p FROM Player p WHERE p.name IN (:player)");
		q.setParameterList("player", player);
		@SuppressWarnings("unchecked")
		List<Player> list = q.list();

		return list;
	}

	@Override
	public int updateView(int view, Long playerId) {
		Session session = sessionfactory.getCurrentSession();

		Query qry = session.createQuery("update Player set view = :view where id=:playerId");
		qry.setParameter("view", view);
		qry.setParameter("playerId", playerId);
		int rowCount = qry.executeUpdate();
		return rowCount;
	}

	@Override
	public List<Player> getDreamPlayerList(int dreamId) {
		Session session = sessionfactory.getCurrentSession();
		/*
		Criteria crit = session.createCriteria(DreamTeam.class);
		List<Player> list=crit.createAlias("playerList", "d").
		add(Restrictions.eq("d.name", dreamId)).list();
		
		return list;*/
		
		/*DetachedCriteria uCrit = DetachedCriteria.forClass(DreamTeam.class, "user");
		uCrit.add(Restrictions.eq("user.id", dreamId));
		uCrit.setProjection(Projections.property("user.id"));
		DetachedCriteria criteria = DetachedCriteria.forClass(Player.class, "role");
		criteria.add(Property.forName("role.name").in(uCrit));
		List lt1 = criteria.getExecutableCriteria(session).list();
		
		System.out.println(lt1);
		return lt1;*/
		
		Query qry = session.createQuery("select a from DreamTeam b join b.playerList a where b.id = :dreamId");
		qry.setParameter("dreamId", dreamId);
		@SuppressWarnings("unchecked")
		List<Player> list= qry.list();
		System.out.println(list.size());
		return list;
	}

}
